package es.dsw.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioReportes {
    private final List<String> reportesUsuarios = new ArrayList<>();

    public void agregarReporte(String reporte) {
        reportesUsuarios.add(reporte);
    }

    public List<String> obtenerReportes() {
        return reportesUsuarios;
    }
}