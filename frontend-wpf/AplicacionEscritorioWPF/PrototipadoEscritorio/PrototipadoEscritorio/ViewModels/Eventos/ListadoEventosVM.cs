using CommunityToolkit.Mvvm.ComponentModel;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Eventos
{
    public partial class ListadoEventosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        public ObservableCollection<Evento> ListaEventos { get; } = new()
        {
            new Evento(1, "Nuevos fondos ODS", "Madrid", "Mayor remuneración para proyectos sostenibles", "/Assets/mundo.png", new DateTime(2026, 6, 15)),
            new Evento(2, "Cumbre del Clima", "Barcelona", "Conferencia internacional sobre cambio climático", "/Assets/mundo.png", new DateTime(2026, 7, 20)),
            new Evento(3, "Reciclaje Tech", "Valencia", "Taller de reciclaje de dispositivos electrónicos", "/Assets/mundo.png", new DateTime(2026, 8, 10)),
            new Evento(4, "Reforestación Urbana", "Sevilla", "Plantación de árboles en zonas urbanas", "/Assets/mundo.png", new DateTime(2026, 9, 5)),
            new Evento(5, "Energía Solar Comunitaria", "Bilbao", "Instalación de paneles solares en comunidades", "/Assets/mundo.png", new DateTime(2026, 10, 12)),
            new Evento(6, "Limpieza de Playas", "Málaga", "Jornada de limpieza de costas y concienciación", "/Assets/mundo.png", new DateTime(2026, 11, 8)),
        };
    }
}
