"""
Convierte DOCUMENTACION.md -> DOCUMENTACION.pdf
Pasos: Mermaid -> SVG -> HTML con estilos -> Chrome headless -> PDF
"""

import subprocess, re, base64, tempfile, sys, io
from pathlib import Path
import markdown

# Forzar UTF-8 en la salida de consola Windows
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding="utf-8", errors="replace")
sys.stderr = io.TextIOWrapper(sys.stderr.buffer, encoding="utf-8", errors="replace")

PROJECT   = Path(__file__).parent
MD_FILE   = PROJECT / "DOCUMENTACION.md"
HTML_FILE = PROJECT / "DOCUMENTACION.html"
PDF_FILE  = PROJECT / "DOCUMENTACION.pdf"
CHROME    = Path("C:/Program Files/Google/Chrome/Application/chrome.exe")
TEMP_DIR  = Path(tempfile.mkdtemp())

# ── 1. Leer markdown ──────────────────────────────────────────────────────────
content = MD_FILE.read_text(encoding="utf-8")
print(f"[1/4] Leído {MD_FILE.name} ({len(content)} caracteres)")

# ── 2. Convertir bloques Mermaid a SVG ────────────────────────────────────────
MERMAID_RE = re.compile(r'```mermaid\n(.*?)\n```', re.DOTALL)
counter = [0]

def mermaid_to_img(match):
    code = match.group(1)
    idx  = counter[0]; counter[0] += 1
    mmd  = TEMP_DIR / f"d{idx}.mmd"
    svg  = TEMP_DIR / f"d{idx}.svg"
    mmd.write_text(code, encoding="utf-8")

    result = subprocess.run(
        f'npx --yes @mermaid-js/mermaid-cli -i "{mmd}" -o "{svg}" '
        f'--backgroundColor transparent --theme default',
        capture_output=True, text=True, cwd=str(PROJECT), shell=True
    )

    if svg.exists():
        b64 = base64.b64encode(svg.read_bytes()).decode()
        print(f"  → diagrama {idx} convertido OK")
        return (
            f'<div class="diagram">'
            f'<img src="data:image/svg+xml;base64,{b64}" alt="diagrama {idx}"/>'
            f'</div>'
        )
    else:
        print(f"  ✗ diagrama {idx} falló: {result.stderr[:200]}")
        return f'<pre class="mermaid-fallback">{code}</pre>'

modified = MERMAID_RE.sub(mermaid_to_img, content)
print(f"[2/4] {counter[0]} diagrama(s) Mermaid procesados")

# ── 3. Markdown → HTML ────────────────────────────────────────────────────────
md_engine = markdown.Markdown(
    extensions=["tables", "fenced_code", "nl2br", "sane_lists", "attr_list", "toc"],
    extension_configs={"toc": {"title": ""}}
)
body = md_engine.convert(modified)

CSS = """
* { box-sizing: border-box; margin: 0; padding: 0; }

@page {
    size: A4;
    margin: 22mm 20mm 22mm 20mm;
}

body {
    font-family: "Segoe UI", Arial, sans-serif;
    font-size: 10.5pt;
    line-height: 1.65;
    color: #1a1a1a;
    background: #fff;
}

/* ── Encabezados ── */
h1 { font-size: 22pt; color: #1B5E20; border-bottom: 3px solid #1B5E20;
     padding-bottom: 6px; margin: 28px 0 12px; page-break-after: avoid; }
h2 { font-size: 16pt; color: #2E7D32; border-bottom: 1.5px solid #A5D6A7;
     padding-bottom: 4px; margin: 24px 0 10px; page-break-after: avoid; }
h3 { font-size: 13pt; color: #388E3C; margin: 18px 0 8px; page-break-after: avoid; }
h4 { font-size: 11pt; color: #43A047; margin: 14px 0 6px; }

/* ── Párrafos y listas ── */
p  { margin: 6px 0 10px; }
ul, ol { margin: 6px 0 10px 22px; }
li { margin-bottom: 4px; }

/* ── Código inline ── */
code {
    background: #F1F8E9;
    border: 1px solid #C8E6C9;
    border-radius: 3px;
    padding: 1px 5px;
    font-family: "Consolas", "Courier New", monospace;
    font-size: 9pt;
    color: #1B5E20;
}

/* ── Bloques de código ── */
pre {
    background: #F8FBF8;
    border: 1px solid #C8E6C9;
    border-left: 4px solid #43A047;
    border-radius: 4px;
    padding: 12px 14px;
    margin: 10px 0 14px;
    overflow-x: auto;
    page-break-inside: avoid;
}
pre code {
    background: none;
    border: none;
    padding: 0;
    color: #1a1a1a;
    font-size: 8.5pt;
    line-height: 1.55;
}

/* ── Tablas ── */
table {
    border-collapse: collapse;
    width: 100%;
    margin: 12px 0 16px;
    font-size: 9.5pt;
    page-break-inside: avoid;
}
thead tr { background: #1B5E20; color: #fff; }
thead th { padding: 8px 10px; text-align: left; font-weight: 600; }
tbody tr:nth-child(even) { background: #F1F8E9; }
tbody tr:nth-child(odd)  { background: #fff; }
tbody td { padding: 7px 10px; border-bottom: 1px solid #E0E0E0; }

/* ── Blockquote ── */
blockquote {
    border-left: 4px solid #81C784;
    background: #F1F8E9;
    padding: 8px 14px;
    margin: 8px 0 12px;
    color: #2E7D32;
    font-style: italic;
}

/* ── Separador ── */
hr {
    border: none;
    border-top: 2px solid #C8E6C9;
    margin: 24px 0;
}

/* ── Diagramas ── */
.diagram {
    text-align: center;
    margin: 16px 0;
    page-break-inside: avoid;
}
.diagram img {
    max-width: 100%;
    height: auto;
}

/* ── Portada (primer h1 + primer table) ── */
.cover h1 {
    font-size: 28pt;
    text-align: center;
    margin-top: 60px;
    border: none;
}

/* ── Saltos de página ── */
h2 { page-break-before: auto; }
h2:first-of-type { page-break-before: avoid; }

.page-break { page-break-after: always; }
"""

HTML_TEMPLATE = f"""<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>EcoQuest — Documentación</title>
  <style>{CSS}</style>
</head>
<body>
{body}
</body>
</html>
"""

HTML_FILE.write_text(HTML_TEMPLATE, encoding="utf-8")
print(f"[3/4] HTML generado → {HTML_FILE.name}")

# ── 4. Chrome headless → PDF ──────────────────────────────────────────────────
if not CHROME.exists():
    print(f"✗ No se encontró Chrome en: {CHROME}")
    sys.exit(1)

# Windows necesita rutas con backslash para --print-to-pdf
pdf_win  = str(PDF_FILE).replace("/", "\\")
html_url = HTML_FILE.as_uri()   # file:///C:/...

cmd = [
    str(CHROME),
    "--headless=new",
    "--disable-gpu",
    "--no-sandbox",
    "--disable-extensions",
    f"--print-to-pdf={pdf_win}",
    "--print-to-pdf-no-header",
    "--no-pdf-header-footer",
    html_url,
]

result = subprocess.run(cmd, capture_output=True, text=True, timeout=60)

if PDF_FILE.exists():
    size_kb = PDF_FILE.stat().st_size // 1024
    print(f"[4/4] PDF generado → {PDF_FILE.name} ({size_kb} KB)")
else:
    print(f"✗ El PDF no se generó. Stderr:\n{result.stderr[:500]}")
    sys.exit(1)
