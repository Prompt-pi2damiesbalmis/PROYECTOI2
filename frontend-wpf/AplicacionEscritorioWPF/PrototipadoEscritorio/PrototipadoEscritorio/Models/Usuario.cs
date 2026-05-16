using CommunityToolkit.Mvvm.ComponentModel;
using Newtonsoft.Json;
using System.Runtime.Serialization;

namespace PrototipadoEscritorio.Models
{
    [DataContract]
    public partial class Usuario : ObservableObject
    {
        [ObservableProperty]
        [JsonProperty("id")]
        [DataMember]
        private int _id;

        [ObservableProperty]
        [JsonProperty("nombreUsuario")]
        [DataMember]
        private string _nombreUsuario = string.Empty;

        [ObservableProperty]
        [JsonProperty("nombre")]
        [DataMember]
        private string _nombre = string.Empty;

        [ObservableProperty]
        [JsonProperty("apellido")]
        [DataMember]
        private string _apellido = string.Empty;

        [ObservableProperty]
        [JsonProperty("descripcion")]
        [DataMember]
        private string _descripcion = string.Empty;

        [ObservableProperty]
        [JsonProperty("edad")]
        [DataMember]
        private int _edad;

        [ObservableProperty]
        [JsonProperty("email")]
        [DataMember]
        private string _email = string.Empty;

        [ObservableProperty]
        [JsonProperty("imagen")]
        [DataMember]
        private string _imagen = string.Empty;

        public string NombreCompleto => string.IsNullOrEmpty(Apellido) ? Nombre : $"{Apellido}, {Nombre}";

        public string Avatar => Imagen;

        public string Comunidades => string.Empty;

        public Usuario() { }
    }
}
