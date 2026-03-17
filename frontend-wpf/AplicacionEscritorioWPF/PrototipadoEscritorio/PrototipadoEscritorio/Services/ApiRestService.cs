using Newtonsoft.Json;
using PrototipadoEscritorio.Models;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PrototipadoEscritorio.Services
{
    public class ApiRestService
    {
        public static List<Producto> GetProductos()
        {
            RestClient client = new RestClient(Properties.Settings.Default.ApiRestEndPoint);
            RestRequest request = new RestRequest("productos", Method.Get);
            RestResponse response = client.Execute(request);
            return JsonConvert.DeserializeObject<List<Producto>>(response.Content);
        }
    }
}
