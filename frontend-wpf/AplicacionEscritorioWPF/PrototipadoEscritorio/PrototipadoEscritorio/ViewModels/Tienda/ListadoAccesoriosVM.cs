using CommunityToolkit.Mvvm.ComponentModel;
using PrototipadoEscritorio.Models;
using PrototipadoEscritorio.Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrototipadoEscritorio.ViewModels.Tienda
{
    public partial class ListadoAccesoriosVM : ObservableObject
    {
        [ObservableProperty]
        private ObservableCollection<Producto> _listaProductos = new();

        public ListadoAccesoriosVM()
        {
            CargarProductos();
        }

        private async void CargarProductos()
        {
            var productosApi = ApiRestService.GetProductos();
            ListaProductos = new ObservableCollection<Producto>(productosApi);
        }
    }
}
