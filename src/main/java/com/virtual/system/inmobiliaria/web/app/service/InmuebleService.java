package com.virtual.system.inmobiliaria.web.app.service;

import com.virtual.system.inmobiliaria.web.app.models.Inmueble;

import java.util.List;

public interface InmuebleService {
    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long inmuebleId);

    List<Inmueble> findAllInmuebles();
}
