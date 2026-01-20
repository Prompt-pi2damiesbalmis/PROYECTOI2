using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CommunityToolkit.Mvvm.ComponentModel;

namespace PrototipadoEscritorio.Models
{
    public partial class UsuarioReto : ObservableObject
    {
        public int UsuarioRetoId { get; set; } // No reactivo
        public int UsuarioId { get; set; }      // No reactivo
        public int RetoId { get; set; }         // No reactivo
        public DateTime FechaCompletado { get; set; } // No reactivo

        [ObservableProperty]
        private bool completado; // Reactivo

        public UsuarioReto() { }

        public UsuarioReto(int usuarioRetoId, int usuarioId, int retoId, bool completado, DateTime fechaCompletado)
        {
            UsuarioRetoId = usuarioRetoId;
            UsuarioId = usuarioId;
            RetoId = retoId;
            Completado = completado;
            FechaCompletado = fechaCompletado;
        }
    }
}
