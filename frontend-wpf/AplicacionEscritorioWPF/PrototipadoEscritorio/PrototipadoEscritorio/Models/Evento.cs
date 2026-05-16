using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Windows.Media;

namespace PrototipadoEscritorio.Models
{
    public partial class Evento : ObservableObject
    {
        private static readonly Random _random = new();
        private static readonly string[] _coloresHex =
        {
            "#FF6B6B", "#4ECDC4", "#45B7D1", "#96CEB4", "#F7DC6F",
            "#DDA0DD", "#98D8C8", "#F39C12", "#BB8FCE", "#85C1E9",
            "#E67E22", "#2ECC71", "#E74C3C", "#3498DB", "#1ABC9C"
        };

        public int EventoId { get; set; }

        [ObservableProperty]
        private string nombre;

        [ObservableProperty]
        private string ubicacion;

        [ObservableProperty]
        private string descripcion;

        [ObservableProperty]
        private string imagen;

        [ObservableProperty]
        private DateTime fecha;

        [ObservableProperty]
        private string nombreComunidad = string.Empty;

        [ObservableProperty]
        private string imagenComunidad = string.Empty;

        public SolidColorBrush ColorBorde { get; } = new((Color)ColorConverter.ConvertFromString(_coloresHex[_random.Next(_coloresHex.Length)]));

        public Evento()
        {
            _ = ColorBorde;
        }

        public Evento(int eventoId, string nombre, string ubicacion, string descripcion, string imagen, DateTime fecha) : this()
        {
            EventoId = eventoId;
            Nombre = nombre;
            Ubicacion = ubicacion;
            Descripcion = descripcion;
            Imagen = imagen;
            Fecha = fecha;
        }

        public Evento(int eventoId, string nombre, string ubicacion, string descripcion, string imagen, DateTime fecha, string nombreComunidad, string imagenComunidad) : this(eventoId, nombre, ubicacion, descripcion, imagen, fecha)
        {
            NombreComunidad = nombreComunidad;
            ImagenComunidad = imagenComunidad;
        }
    }
}

