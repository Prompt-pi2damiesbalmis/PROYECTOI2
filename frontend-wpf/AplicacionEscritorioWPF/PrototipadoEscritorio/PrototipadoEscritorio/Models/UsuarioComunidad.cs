using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CommunityToolkit.Mvvm.ComponentModel;

namespace PrototipadoEscritorio.Models
{
    public partial class UsuarioComunidad : ObservableObject
    {
        public int UsuarioComunidadId { get; set; } // No reactivo
        public int UsuarioId { get; set; }          // No reactivo
        public int ComunidadId { get; set; }        // No reactivo

        [ObservableProperty]
        private Rol rol;                            // Reactivo

        public UsuarioComunidad() { }

        public UsuarioComunidad(int usuarioComunidadId, int usuarioId, int comunidadId, Rol rol)
        {
            UsuarioComunidadId = usuarioComunidadId;
            UsuarioId = usuarioId;
            ComunidadId = comunidadId;
            Rol = rol;
        }
    }
}

