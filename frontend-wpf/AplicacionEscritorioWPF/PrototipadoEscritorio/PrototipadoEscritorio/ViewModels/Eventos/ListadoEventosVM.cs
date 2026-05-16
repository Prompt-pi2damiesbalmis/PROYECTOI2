using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Eventos
{
    public partial class ListadoEventosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private DetalleEventoUserControlVM _detalleEventoVM = new();

        public ObservableCollection<Evento> ListaEventos { get; } = new()
        {
            new Evento(1, "Nuevos fondos ODS", "Madrid", "Mayor remuneración para proyectos sostenibles", "/Assets/mundo.png", new DateTime(2026, 6, 15), "EcoComunidad", "/Assets/mundo.png"),
            new Evento(2, "Cumbre del Clima", "Barcelona", "Conferencia internacional sobre cambio climático", "/Assets/mundo.png", new DateTime(2026, 7, 20), "GreenSostenibilidad", "/Assets/mundo.png"),
            new Evento(3, "Reciclaje Tech", "Valencia", "Taller de reciclaje de dispositivos electrónicos", "/Assets/mundo.png", new DateTime(2026, 8, 10), "TecnoRecicla", "/Assets/mundo.png"),
            new Evento(4, "Reforestación Urbana", "Sevilla", "Plantación de árboles en zonas urbanas", "/Assets/mundo.png", new DateTime(2026, 9, 5), "Bosque Urbano", "/Assets/mundo.png"),
            new Evento(5, "Energía Solar Comunitaria", "Bilbao", "Instalación de paneles solares en comunidades", "/Assets/mundo.png", new DateTime(2026, 10, 12), "Sol para Todos", "/Assets/mundo.png"),
            new Evento(6, "Limpieza de Playas", "Málaga", "Jornada de limpieza de costas y concienciación", "/Assets/mundo.png", new DateTime(2026, 11, 8), "Océano Vivo", "/Assets/mundo.png"),
        };

        public ListadoEventosVM()
        {
            WeakReferenceMessenger.Default.Register<CerrarDetalleEventoMessage>(this, (r, m) =>
            {
                DetalleEventoVM.Evento = new();
                ModalVisible = false;
            });
        }

        [RelayCommand]
        private void VerDetalleEvento(Evento evento)
        {
            if (evento == null) return;
            DetalleEventoVM.Evento = evento;
            ModalVisible = true;
        }

        [RelayCommand]
        private void CerrarModal()
        {
            DetalleEventoVM.Evento = new();
            ModalVisible = false;
        }
    }
}
