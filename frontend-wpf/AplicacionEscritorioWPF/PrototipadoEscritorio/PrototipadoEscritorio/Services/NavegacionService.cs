using PrototipadoEscritorio.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace PrototipadoEscritorio.Services
{
    internal class NavegacionService
    {
        private static UserControl usuariosVista, accesoriosVista, eventosVista, comunidadesVista;
        private static UserControl añadirAccesorio;

        // Evento para notificar cambios en la navegación
        public event EventHandler<UserControl>? NavegacionSolicitada;

        public UserControl ObtenerVentanaUsuarios()
        {
            if (usuariosVista is null)
            {
                usuariosVista = new UsuariosUserControl();
            }
            NotificarNavegacion(usuariosVista);
            return usuariosVista;
        }

        public UserControl ObtenerVentanaAccesorios()
        {
            if (accesoriosVista is null)
            {
                accesoriosVista = new AccesoriosUserControl();
            }
            NotificarNavegacion(accesoriosVista);
            return accesoriosVista;
        }

        public UserControl ObtenerVentanaEventos()
        {
            if (eventosVista is null)
            {
                eventosVista = new EventosUserControl();
            }
            NotificarNavegacion(eventosVista);
            return eventosVista;
        }

        public UserControl ObtenerVentanaComunidades()
        {
            if (comunidadesVista is null)
            {
                comunidadesVista = new ComunidadesUserControl();
            }
            NotificarNavegacion(comunidadesVista);
            return comunidadesVista;
        }

        public UserControl ObtenerVentanaAñadirAccesorio()
        {
            if (añadirAccesorio is null)
            {
                añadirAccesorio = new AñadirAccesorioUserControl();
            }
            NotificarNavegacion(añadirAccesorio);
            return añadirAccesorio;
        }

        private void NotificarNavegacion(UserControl control)
        {
            NavegacionSolicitada?.Invoke(this, control);
        }
    }
}