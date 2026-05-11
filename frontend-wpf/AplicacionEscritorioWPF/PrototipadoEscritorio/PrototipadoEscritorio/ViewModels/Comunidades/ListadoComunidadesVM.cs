using CommunityToolkit.Mvvm.ComponentModel;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Comunidades
{
    public partial class ListadoComunidadesVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        public ObservableCollection<Comunidad> ListaComunidades { get; } = new()
        {
            new Comunidad(1, "Eco Acción", "/Assets/comunidad2.jpg"),
            new Comunidad(2, "Tribu Verde", "/Assets/comunidad3.jpg"),
            new Comunidad(3, "Playas Limpias", "/Assets/comunidad6.jpg"),
            new Comunidad(4, "Todos Unidos", "/Assets/todosunidos.png"),
            new Comunidad(5, "Eco Connection", "/Assets/comunidad4.jpg"),
            new Comunidad(6, "Eco Tech", "/Assets/EcoTech.jpg"),
        };
    }
}
