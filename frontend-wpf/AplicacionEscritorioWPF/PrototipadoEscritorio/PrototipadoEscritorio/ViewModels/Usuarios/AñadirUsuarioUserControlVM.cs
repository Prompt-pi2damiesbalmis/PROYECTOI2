using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrototipadoEscritorio.ViewModels.Usuarios
{
    public partial class AñadirUsuarioUserControlVM : ObservableObject
    {
        [ObservableProperty]
        private string _nombreUsuario = string.Empty;

        [ObservableProperty]
        private string _nombreCompleto = string.Empty;

        [ObservableProperty]
        private string _email = string.Empty;

        [RelayCommand]
        private async Task Guardar()
        {
            // Implementar lógica de guardado
        }
    }
}
