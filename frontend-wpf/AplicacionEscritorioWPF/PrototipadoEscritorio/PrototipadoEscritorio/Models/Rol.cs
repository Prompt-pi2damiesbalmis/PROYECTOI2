using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CommunityToolkit.Mvvm.ComponentModel;

namespace PrototipadoEscritorio.Models
{
    public partial class Rol : ObservableObject
    {
        public Rol() { }

        public Rol(int id, string nombreRol)
        {
            Id = id;
            NombreRol = nombreRol;
        }

        public int Id { get; set; } // No reactivo, identificador

        [ObservableProperty]
        private string nombreRol;
    }
}
