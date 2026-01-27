using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using PrototipadoEscritorio.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Navigation;

namespace PrototipadoEscritorio.ViewModels
{
    public partial class MainVM : ObservableObject
    {
        private NavegacionService sn;

        // Propiedad "ContenidoVentana" para contener el UserControl elegido.
        [ObservableProperty]
        private UserControl? _contenidoVentana;

        // Constructor.
        //public MainVM()
        //{
        //    sn = new NavegacionService();
        //    ContenidoVentana = sn.ObtenerListadoPersonas();
        //}

        //[RelayCommand]
        //private void AbrirNuevaPersona()
        //{
        //    ContenidoVentana = sn.ObtenerNuevaPersona();
        //}

        //[RelayCommand]
        //private void AbrirListadoPersonas()
        //{
        //    ContenidoVentana = sn.ObtenerListadoPersonas();
        //}

        //[RelayCommand]
        //private void AbrirConsultaPersonas()
        //{
        //    ContenidoVentana = sn.ObtenerConsultaPersonas();
        //}
    }
}
