using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Eventos
{
    public partial class ListadoEliminarEventosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private EliminarEventoUserControlVM _eliminarEventoVM = new();

        public ObservableCollection<Evento> ListaEventos { get; } = new()
        {
            new Evento(1, "Nuevos fondos ODS", "Madrid", "Mayor remuneración para proyectos sostenibles", "/Assets/mundo.png", new DateTime(2026, 6, 15)),
            new Evento(2, "Cumbre del Clima", "Barcelona", "Conferencia internacional sobre cambio climático", "/Assets/mundo.png", new DateTime(2026, 7, 20)),
            new Evento(3, "Reciclaje Tech", "Valencia", "Taller de reciclaje de dispositivos electrónicos", "/Assets/mundo.png", new DateTime(2026, 8, 10)),
        };

        [RelayCommand]
        private void EliminarEvento()
        {
            EliminarEventoVM.Razon = string.Empty;
            ModalVisible = true;
        }

        [RelayCommand]
        private void CerrarModal() => ModalVisible = false;
    }
}
