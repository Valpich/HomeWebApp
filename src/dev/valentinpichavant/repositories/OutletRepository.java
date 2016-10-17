package dev.valentinpichavant.repositories;

import dev.valentinpichavant.beans.Outlet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev.valentinpichavant on 10/17/16.
 */
@Component
public class OutletRepository {

    public List<Outlet> findAll() {
        return new ArrayList<>();

    }

}