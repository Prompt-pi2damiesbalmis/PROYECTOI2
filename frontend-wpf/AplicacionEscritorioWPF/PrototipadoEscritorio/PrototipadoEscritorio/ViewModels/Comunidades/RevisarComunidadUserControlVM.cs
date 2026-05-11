using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class RevisarComunidadUserControlVM : ObservableObject
    {
        [ObservableProperty]
        private Comunidad _comunidad;

        [ObservableProperty]
        private string _razon = string.Empty;

        public RevisarComunidadUserControlVM()
        {
            Comunidad = new Comunidad();
        }

        [RelayCommand]
        private void Cancelar()
        {
            WeakReferenceMessenger.Default.Send(new RevisarComunidadMessage(null));
        }

        [RelayCommand]
        private void Confirmar()
        {
            WeakReferenceMessenger.Default.Send(new RevisarComunidadMessage(Comunidad));
        }
    }
}
