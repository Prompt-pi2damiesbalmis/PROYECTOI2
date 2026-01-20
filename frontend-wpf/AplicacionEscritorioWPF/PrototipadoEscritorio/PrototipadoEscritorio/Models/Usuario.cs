using CommunityToolkit.Mvvm.ComponentModel;
using PrototipadoEscritorio.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace PrototipadoEscritorio.Models
{
    public partial class Usuario : ObservableObject
    {
        public int UsuarioId { get; set; } // No reactivo, clave primaria

        [ObservableProperty]
        private string contraseña;

        [ObservableProperty]
        private bool admin;

        [ObservableProperty]
        private string nombreUsuario;

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private string apellidos;

        [ObservableProperty]
        private string correo;

        [ObservableProperty]
        private string imagen;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private DateTime edad;

        [ObservableProperty]
        private int puntos;

        [ObservableProperty]
        private int puntosExperiencia;

        [ObservableProperty]
        private Nivel nivel;

        [ObservableProperty]
        private List<Comunidad> comunidades;

        [ObservableProperty]
        private List<Producto> productos;

        public Usuario()
        {
            comunidades = new List<Comunidad>();
            productos = new List<Producto>();
        }

        public Usuario(int usuarioId, string contraseña, bool admin, string nombreUsuario, string nombre,
                    string apellidos, string correo, string imagen, string descripcion, DateTime edad,
                    int puntos, int puntosExperiencia, Nivel nivel)
        {
            UsuarioId = usuarioId;
            Contraseña = contraseña;
            Admin = admin;
            NombreUsuario = nombreUsuario;
            Nombre = nombre;
            Apellidos = apellidos;
            Correo = correo;
            Imagen = imagen;
            Descripcion = descripcion;
            Edad = edad;
            Puntos = puntos;
            PuntosExperiencia = puntosExperiencia;
            Nivel = nivel;

            Comunidades = new List<Comunidad>();
            Productos = new List<Producto>();
        }
    }
}


