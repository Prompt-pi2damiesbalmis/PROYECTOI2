using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PrototipadoEscritorio.Services;

namespace PrototipadoEscritorio.ViewModels
{
    public partial class AccesoriosUserControlVM : ObservableObject
    {

        private NavegacionService sn;

        [ObservableProperty]
        private bool isDockVisible = false;

        public AccesoriosUserControlVM()
        {
            sn = new NavegacionService();
        }

        [RelayCommand]
        private void ToggleDock()
        {
            IsDockVisible = !IsDockVisible;
        }

        // Navegación entre ventanas de accesorios
        [RelayCommand]
        private void AbrirAñadirAccesorio()
        {
            sn.ObtenerVentanaAñadirAccesorio();
        }
    }
}