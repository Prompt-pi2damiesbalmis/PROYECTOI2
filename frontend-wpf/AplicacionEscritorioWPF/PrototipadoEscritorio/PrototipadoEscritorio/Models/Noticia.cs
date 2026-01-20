using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Noticia : ObservableObject
    {
        public int NoticiaId { get; set; } // No reactivo

        [ObservableProperty]
        private string autor;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private string imagen;

        [ObservableProperty]
        private string nombre;

        public Noticia() { }

        public Noticia(int noticiaId, string autor, string descripcion, string imagen, string nombre)
        {
            NoticiaId = noticiaId;
            Autor = autor;
            Descripcion = descripcion;
            Imagen = imagen;
            Nombre = nombre;
        }
    }
}

