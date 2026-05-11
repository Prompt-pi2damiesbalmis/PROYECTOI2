using CommunityToolkit.Mvvm.ComponentModel;
using PrototipadoEscritorio.Models;
using System.Collections.ObjectModel;

namespace PrototipadoEscritorio.ViewModels.Usuarios
{
    public partial class ListadoUsuariosVM : ObservableObject
    {
        [ObservableProperty]
        private string _textoBusqueda = string.Empty;

        public ObservableCollection<Usuario> ListaUsuarios { get; } = new()
        {
            new Usuario(1, "juan_garcia", "García, Juan", "juan@email.com", "/Assets/avatares.png"),
            new Usuario(2, "maria_lopez", "López, María", "maria@email.com", "/Assets/avatares.png"),
            new Usuario(3, "carlos_rod", "Rodríguez, Carlos", "carlos@email.com", "/Assets/avatares.png"),
            new Usuario(4, "ana_martin", "Martín, Ana", "ana@email.com", "/Assets/avatares.png"),
            new Usuario(5, "luis_fer", "Fernández, Luis", "luis@email.com", "/Assets/avatares.png"),
            new Usuario(6, "sofia_perez", "Pérez, Sofía", "sofia@email.com", "/Assets/avatares.png"),
        };
    }
}
