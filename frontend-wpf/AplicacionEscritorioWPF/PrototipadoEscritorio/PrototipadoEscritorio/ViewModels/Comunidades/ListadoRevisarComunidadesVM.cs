using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using PrototipadoEscritorio.Services;
using System.Collections.ObjectModel;
using System.Linq;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class ListadoRevisarComunidadesVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private bool _modalDetalleVisible = false;

        [ObservableProperty]
        private RevisarComunidadUserControlVM _revisarComunidadVM = new();

        [ObservableProperty]
        private DetalleComunidadUserControlVM _detalleComunidadVM = new();

        public ObservableCollection<Comunidad> ListaComunidades { get; } = new();

        public ListadoRevisarComunidadesVM()
        {
            CargarComunidades();

            WeakReferenceMessenger.Default.Register<ComunidadAñadidaMessage>(this, (r, m) =>
            {
                CargarComunidades();
            });

            WeakReferenceMessenger.Default.Register<RevisarComunidadMessage>(this, (r, m) =>
            {
                ModalVisible = false;
                CargarComunidades();
            });

            WeakReferenceMessenger.Default.Register<CerrarDetalleComunidadMessage>(this, (r, m) =>
            {
                DetalleComunidadVM.Comunidad = new();
                ModalDetalleVisible = false;
            });
        }

        public void CargarComunidades()
        {
            var comunidades = ApiRestService.GetComunidadesPorEstado("EN_REVISION");
            ListaComunidades.Clear();
            foreach (var c in comunidades)
                ListaComunidades.Add(c);
        }

        partial void OnTextoBusquedaChanged(string value)
        {
            if (string.IsNullOrWhiteSpace(value))
            {
                CargarComunidades();
                return;
            }
            var todas = ApiRestService.GetComunidadesPorEstado("EN_REVISION");
            var resultados = todas.Where(c => c.Nombre.Contains(value, System.StringComparison.OrdinalIgnoreCase)).ToList();
            ListaComunidades.Clear();
            foreach (var c in resultados)
                ListaComunidades.Add(c);
        }

        [RelayCommand]
        private void RevisarComunidad(Comunidad comunidad)
        {
            if (comunidad == null) return;
            RevisarComunidadVM.Comunidad = comunidad;
            RevisarComunidadVM.Razon = string.Empty;
            ModalVisible = true;
        }

        [RelayCommand]
        private void VerDetalleComunidad(Comunidad comunidad)
        {
            if (comunidad == null) return;
            DetalleComunidadVM.Comunidad = comunidad;
            DetalleComunidadVM.ColorTipo = "amarillo";
            ModalDetalleVisible = true;
        }

        [RelayCommand]
        private void CerrarModal()
        {
            if (ModalVisible) ModalVisible = false;
            if (ModalDetalleVisible)
            {
                DetalleComunidadVM.Comunidad = new();
                ModalDetalleVisible = false;
            }
        }
    }
}
