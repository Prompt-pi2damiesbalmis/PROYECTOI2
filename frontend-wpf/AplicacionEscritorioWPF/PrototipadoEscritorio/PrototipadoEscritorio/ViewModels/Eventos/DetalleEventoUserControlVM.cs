using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;

namespace PrototipadoEscritorio.ViewModels.Eventos
{
    public partial class DetalleEventoUserControlVM : ObservableObject
    {
        [ObservableProperty]
        private Evento _evento = new();

        public string FechaFormateada => Evento.Fecha.ToString("dd/MM/yyyy");

        [RelayCommand]
        private void Cerrar()
        {
            WeakReferenceMessenger.Default.Send(new CerrarDetalleEventoMessage(true));
        }
    }
}
