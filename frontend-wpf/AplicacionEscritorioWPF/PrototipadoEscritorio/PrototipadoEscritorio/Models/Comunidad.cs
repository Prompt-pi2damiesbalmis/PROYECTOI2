using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Comunidad : ObservableObject
    {
        public int ComunidadId { get; set; } // No reactivo

        [ObservableProperty]
        private List<Usuario> usuarios;

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private List<Evento> eventos;

        [ObservableProperty]
        private string imagen;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private Rol rol;

        public Comunidad()
        {
            usuarios = new List<Usuario>();
            eventos = new List<Evento>();
        }

        public Comunidad(int comunidadId, string nombre, string imagen, string descripcion, Rol rol)
        {
            ComunidadId = comunidadId;
            Nombre = nombre;
            Imagen = imagen;
            Descripcion = descripcion;
            Rol = rol;

            usuarios = new List<Usuario>();
            eventos = new List<Evento>();
        }
    }
}

