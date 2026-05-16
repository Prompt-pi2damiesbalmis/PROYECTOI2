using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using PrototipadoEscritorio.Messages;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class ListadoEliminarComunidadesVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        [ObservableProperty]
        private bool _modalVisible = false;

        [ObservableProperty]
        private EliminarComunidadUserControlVM _eliminarComunidadVM = new();

        public ObservableCollection<Comunidad> ListaComunidades { get; } = new()
        {
            new Comunidad(1, "Eco Acción", "/Assets/comunidad2.jpg"),
            new Comunidad(2, "Tribu Verde", "/Assets/comunidad3.jpg"),
            new Comunidad(3, "Playas Limpias", "/Assets/comunidad6.jpg"),
        };

        public ListadoEliminarComunidadesVM()
        {
            WeakReferenceMessenger.Default.Register<EliminarComunidadMessage>(this, (r, m) =>
            {
                ModalVisible = false;
            });
        }

        [RelayCommand]
        private void EliminarComunidad(Comunidad comunidad)
        {
            if (comunidad == null) return;
            EliminarComunidadVM.Comunidad = comunidad;
            ModalVisible = true;
        }

        [RelayCommand]
        private void CerrarModal() => ModalVisible = false;
    }
}
