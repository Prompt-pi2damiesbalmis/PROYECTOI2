using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Nivel : ObservableObject
    {
        public int NivelId { get; set; } // No reactivo

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private int puntos;

        [ObservableProperty]
        private string icono;

        public Nivel() { }

        public Nivel(int nivelId, string nombre, string descripcion, int puntos, string icono)
        {
            NivelId = nivelId;
            Nombre = nombre;
            Descripcion = descripcion;
            Puntos = puntos;
            Icono = icono;
        }

        public void NivelSubir()
        {
            // Aquí puedes implementar la lógica para subir de nivel
            // Por ejemplo:
            // Puntos += 100;
        }
    }
}

