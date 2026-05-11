using CommunityToolkit.Mvvm.ComponentModel;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.Models
{
    public partial class Usuario : ObservableObject
    {
        public int UsuarioId { get; set; }

        [ObservableProperty]
        private string nombreUsuario = string.Empty;

        [ObservableProperty]
        private string nombreCompleto = string.Empty;

        [ObservableProperty]
        private string email = string.Empty;

        [ObservableProperty]
        private string avatar = string.Empty;

        public Usuario() { }

        public Usuario(int usuarioId, string nombreUsuario, string nombreCompleto, string email, string avatar)
        {
            UsuarioId = usuarioId;
            NombreUsuario = nombreUsuario;
            NombreCompleto = nombreCompleto;
            Email = email;
            Avatar = avatar;
        }
    }
}
