using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CommunityToolkit.Mvvm.ComponentModel;

namespace PrototipadoEscritorio.Models
{
    public partial class UsuarioEvento : ObservableObject
    {
        public int UsuarioEventoId { get; set; } // No reactivo
        public int UsuarioId { get; set; }        // No reactivo
        public int EventoId { get; set; }         // No reactivo
        public DateTime FechaRegistro { get; set; } // No reactivo

        [ObservableProperty]
        private bool asistencia; // Reactivo

        public UsuarioEvento() { }

        public UsuarioEvento(int usuarioEventoId, int usuarioId, int eventoId, DateTime fechaRegistro, bool asistencia)
        {
            UsuarioEventoId = usuarioEventoId;
            UsuarioId = usuarioId;
            EventoId = eventoId;
            FechaRegistro = fechaRegistro;
            Asistencia = asistencia;
        }
    }
}

