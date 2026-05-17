using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class DetalleComunidadUserControlVM : ObservableObject
    {
        [ObservableProperty]
        private Comunidad _comunidad = new();

        partial void OnComunidadChanged(Comunidad value)
        {
            OnPropertyChanged(nameof(Comunidad));
        }

        [RelayCommand]
        private void Cerrar()
        {
            WeakReferenceMessenger.Default.Send(new CerrarDetalleComunidadMessage(true));
        }
    }
}
