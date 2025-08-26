package acceso;

import java.io.*;
import java.util.*;

public class UsuarioDAO {
    private File archivo;

    public UsuarioDAO(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    // Registrar nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getNombreUsuario()) != null) {
            return false; // ya existe
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(usuario.toString());
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Buscar usuario por nombre
    public Usuario buscarUsuario(String nombreUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.fromString(linea);
                if (u != null && u.getNombreUsuario().equals(nombreUsuario)) {
                    return u;
                }
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    // Validar login
    public boolean iniciarSesion(String usuario, String contrasena) {
        Usuario u = buscarUsuario(usuario);
        return u != null && u.getContrasena().equals(contrasena);
    }

    // Cambiar contraseña
    public boolean cambiarContrasena(String usuario, String nuevaContrasena) {
        List<Usuario> usuarios = new ArrayList<>();
        boolean actualizado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.fromString(linea);
                if (u != null) {
                    if (u.getNombreUsuario().equals(usuario)) {
                        u = new Usuario(usuario, nuevaContrasena);
                        actualizado = true;
                    }
                    usuarios.add(u);
                }
            }
        } catch (IOException e) {
            return false;
        }

        if (actualizado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (Usuario u : usuarios) {
                    bw.write(u.toString());
                    bw.newLine();
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
}
