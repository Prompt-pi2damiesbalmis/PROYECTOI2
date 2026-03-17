using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;

namespace PrototipadoEscritorio.ViewModels
{
    public partial class EliminarUsuarioUserControlVM : ObservableObject
    {
        // Usuario que se muestra en la vista
        [ObservableProperty]
        private Usuario usuario;

        public EliminarUsuarioUserControlVM( )
        {
            Usuario = usuario;
        }

        // Comando cancelar
        [RelayCommand]
        private void Cancelar()
        {
            // Puedes enviar un mensaje indicando que no se elimina
            WeakReferenceMessenger.Default.Send(new EliminarUsuarioMessage(null));
        }

        // Comando confirmar
        [RelayCommand]
        private void Confirmar()
        {
            WeakReferenceMessenger.Default.Send(new EliminarUsuarioMessage(Usuario));
        }
    }
}

