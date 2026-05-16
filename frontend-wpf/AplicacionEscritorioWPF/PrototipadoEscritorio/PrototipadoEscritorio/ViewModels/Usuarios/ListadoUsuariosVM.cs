using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Usuarios
{
    public partial class ListadoUsuariosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private BloquearUsuarioUserControlVM _bloquearUsuarioVM = new();

        public ObservableCollection<Usuario> ListaUsuarios { get; } = new()
        {
            new Usuario(1, "juan_garcia", "García, Juan", "juan@email.com", "/Assets/avatares.png", "Eco Acción, Tribu Verde"),
            new Usuario(2, "maria_lopez", "López, María", "maria@email.com", "/Assets/avatares.png", "Playas Limpias, Todos Unidos"),
            new Usuario(3, "carlos_rod", "Rodríguez, Carlos", "carlos@email.com", "/Assets/avatares.png", "Eco Connection"),
            new Usuario(4, "ana_martin", "Martín, Ana", "ana@email.com", "/Assets/avatares.png", "Tribu Verde, Eco Tech"),
            new Usuario(5, "luis_fer", "Fernández, Luis", "luis@email.com", "/Assets/avatares.png", "Eco Acción, Playas Limpias"),
            new Usuario(6, "sofia_perez", "Pérez, Sofía", "sofia@email.com", "/Assets/avatares.png", "Todos Unidos, Eco Connection"),
        };

        public ListadoUsuariosVM()
        {
            WeakReferenceMessenger.Default.Register<BloquearUsuarioMessage>(this, (r, m) =>
            {
                ModalVisible = false;
            });
        }

        [RelayCommand]
        private void BloquearUsuario(Usuario usuario)
        {
            if (usuario == null) return;
            BloquearUsuarioVM.Usuario = usuario;
            BloquearUsuarioVM.Causa = string.Empty;
            BloquearUsuarioVM.Duracion = string.Empty;
            ModalVisible = true;
        }

        [RelayCommand]
        private void CerrarModal() => ModalVisible = false;
    }
}
