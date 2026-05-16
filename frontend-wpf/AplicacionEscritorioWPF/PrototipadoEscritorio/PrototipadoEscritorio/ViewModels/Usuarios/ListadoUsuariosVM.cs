using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using PrototipadoEscritorio.Services;
using System.Collections.ObjectModel;
using System.Linq;

namespace PrototipadoEscritorio.ViewModels.Usuarios
{
    public partial class ListadoUsuariosVM : ObservableObject, IRecipient<UsuarioAñadidoMessage>
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private BloquearUsuarioUserControlVM _bloquearUsuarioVM = new();

        public ObservableCollection<Usuario> ListaUsuarios { get; } = new();

        private System.Collections.Generic.List<Usuario> _todosUsuarios = new();

        public ListadoUsuariosVM()
        {
            WeakReferenceMessenger.Default.Register<BloquearUsuarioMessage>(this, (r, m) =>
            {
                ModalVisible = false;
            });

            WeakReferenceMessenger.Default.Register(this);
            CargarUsuarios();
        }

        public void CargarUsuarios()
        {
            var usuarios = ApiRestService.GetUsuarios();
            _todosUsuarios = usuarios ?? new System.Collections.Generic.List<Usuario>();
            FiltrarUsuarios();
        }

        partial void OnTextoBusquedaChanged(string value)
        {
            FiltrarUsuarios();
        }

        private void FiltrarUsuarios()
        {
            ListaUsuarios.Clear();
            var filtrados = string.IsNullOrWhiteSpace(TextoBusqueda)
                ? _todosUsuarios
                : _todosUsuarios.Where(u =>
                    u.NombreUsuario.Contains(TextoBusqueda) ||
                    u.Nombre.Contains(TextoBusqueda) ||
                    u.Apellido.Contains(TextoBusqueda) ||
                    u.Email.Contains(TextoBusqueda)).ToList();

            foreach (var u in filtrados)
            {
                ListaUsuarios.Add(u);
            }
        }

        public void Receive(UsuarioAñadidoMessage message)
        {
            CargarUsuarios();
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
