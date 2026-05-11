using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PrototipadoEscritorio.Services;
using System.Windows.Controls;

namespace PrototipadoEscritorio.ViewModels
{
    public partial class UsuairosUserControlVM : ObservableObject
    {
        private NavegacionService sn;

        [ObservableProperty]
        private bool isDockVisible = false;

        [ObservableProperty]
        private UserControl? _contenidoVentana;

        public UsuairosUserControlVM()
        {
            sn = new NavegacionService();
            ContenidoVentana = sn.ObtenerVentanaListadoUsuarios();
        }

        [RelayCommand]
        private void ToggleDock()
        {
            IsDockVisible = !IsDockVisible;
        }

        [RelayCommand]
        private void AbrirListadoUsuarios()
        {
            ContenidoVentana = sn.ObtenerVentanaListadoUsuarios();
        }

        [RelayCommand]
        private void AbrirAñadirUsuario()
        {
            ContenidoVentana = sn.ObtenerVentanaAñadirUsuario();
        }

        [RelayCommand]
        private void AbrirEliminarUsuario()
        {
            ContenidoVentana = sn.ObtenerVentanaEliminarUsuarios();
        }
    }
}
