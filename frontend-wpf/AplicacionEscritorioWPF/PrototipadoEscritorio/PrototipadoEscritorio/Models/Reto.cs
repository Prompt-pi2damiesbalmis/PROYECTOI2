using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Reto : ObservableObject
    {
        public int RetoId { get; set; } // No reactivo

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private int puntos;

        public Reto() { }

        public Reto(int retoId, string nombre, string descripcion, int puntos)
        {
            RetoId = retoId;
            Nombre = nombre;
            Descripcion = descripcion;
            Puntos = puntos;
        }
    }
}

