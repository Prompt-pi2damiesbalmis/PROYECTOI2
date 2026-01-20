using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Producto : ObservableObject
    {
        public int ProductoId { get; set; } // No reactivo

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private int puntos;

        public Producto() { }

        public Producto(int productoId, string nombre, string descripcion, int puntos)
        {
            ProductoId = productoId;
            Nombre = nombre;
            Descripcion = descripcion;
            Puntos = puntos;
        }
    }
}

