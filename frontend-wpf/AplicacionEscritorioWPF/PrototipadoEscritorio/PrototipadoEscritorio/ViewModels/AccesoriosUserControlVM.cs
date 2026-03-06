using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PrototipadoEscritorio.Services;
using System.Windows.Controls;

namespace PrototipadoEscritorio.ViewModels
{
    public partial class AccesoriosUserControlVM : ObservableObject
    {

        private NavegacionService sn;

        [ObservableProperty]
        private bool isDockVisible = false;

        [ObservableProperty]
        private UserControl? _contenidoVentana;

        public AccesoriosUserControlVM()
        {
            sn = new NavegacionService();
            ContenidoVentana = sn.ObtenerVentanaListadoAccesorios();
        }

        [RelayCommand]
        private void ToggleDock()
        {
            IsDockVisible = !IsDockVisible;
        }

        [RelayCommand]
        private void AbrirListadoAccesorios()
        {
            ContenidoVentana = sn.ObtenerVentanaAccesorios();
        }

        [RelayCommand]
        private void AbrirAñadirAccesorio()
        {
            ContenidoVentana = sn.ObtenerVentanaAñadirAccesorio();
        }
    }
}