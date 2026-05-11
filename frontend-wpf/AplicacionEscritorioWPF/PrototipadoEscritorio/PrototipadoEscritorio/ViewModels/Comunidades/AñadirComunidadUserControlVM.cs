using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class AñadirComunidadUserControlVM : ObservableObject
    {
        [ObservableProperty]
        private string _nombre = string.Empty;

        [ObservableProperty]
        private string? _rutaImagenLocal;

        [ObservableProperty]
        private BitmapImage? _previsualizacion;

        [RelayCommand]
        private void SeleccionarImagen()
        {
            var dialog = new OpenFileDialog
            {
                Filter = "Imágenes|*.jpg;*.jpeg;*.png;*.gif;*.webp;*.bmp",
                Title = "Seleccionar imagen"
            };

            if (dialog.ShowDialog() == true)
            {
                RutaImagenLocal = dialog.FileName;

                var bmp = new BitmapImage();
                bmp.BeginInit();
                bmp.UriSource = new Uri(RutaImagenLocal);
                bmp.CacheOption = BitmapCacheOption.OnLoad;
                bmp.EndInit();
                Previsualizacion = bmp;
            }
        }

        [RelayCommand]
        private async Task Guardar()
        {
            // Implementar lógica de guardado
        }
    }
}
