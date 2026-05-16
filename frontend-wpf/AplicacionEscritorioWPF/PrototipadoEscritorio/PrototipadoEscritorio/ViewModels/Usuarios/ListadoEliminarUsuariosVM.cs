using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Usuarios
{
    public partial class ListadoEliminarUsuariosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private EliminarUsuarioUserControlVM _eliminarUsuarioVM = new();

        public ObservableCollection<Usuario> ListaUsuarios { get; } = new()
        {
            new Usuario(1, "juan_garcia", "García, Juan", "juan@email.com", "/Assets/avatares.png", "Eco Acción, Tribu Verde"),
            new Usuario(2, "maria_lopez", "López, María", "maria@email.com", "/Assets/avatares.png", "Playas Limpias, Todos Unidos"),
            new Usuario(3, "carlos_rod", "Rodríguez, Carlos", "carlos@email.com", "/Assets/avatares.png", "Eco Connection"),
        };

        public ListadoEliminarUsuariosVM()
        {
            WeakReferenceMessenger.Default.Register<EliminarUsuarioMessage>(this, (r, m) =>
            {
                ModalVisible = false;
            });
        }

        [RelayCommand]
        private void EliminarUsuario(Usuario usuario)
        {
            if (usuario == null) return;
            EliminarUsuarioVM.Usuario = usuario;
            ModalVisible = true;
        }

        [RelayCommand]
        private void CerrarModal() => ModalVisible = false;
    }
}
