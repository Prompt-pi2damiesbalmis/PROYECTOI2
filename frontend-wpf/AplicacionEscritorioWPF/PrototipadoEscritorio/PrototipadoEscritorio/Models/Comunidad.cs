using CommunityToolkit.Mvvm.ComponentModel;

namespace PrototipadoEscritorio.Models
{
    public partial class Comunidad : ObservableObject
    {
        public int ComunidadId { get; set; }

        [ObservableProperty]
        private string nombre = string.Empty;

        [ObservableProperty]
        private string imagen = string.Empty;

        public Comunidad() { }

        public Comunidad(int comunidadId, string nombre, string imagen)
        {
            ComunidadId = comunidadId;
            Nombre = nombre;
            Imagen = imagen;
        }
    }
}
