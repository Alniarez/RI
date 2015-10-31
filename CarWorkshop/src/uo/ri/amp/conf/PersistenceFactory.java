package uo.ri.amp.conf;

import uo.ri.amp.persistence.*;
import uo.ri.amp.persistence.impl.*;

/**
 * Created by Jorge.
 */
public class PersistenceFactory {

    public static GradeGateway getGradeGateway() {
        return new GradeGatewayImpl();
    }

    public static CertificateGateway getCertificateGateway() {
        return new CertificateGatewayImpl();
    }

    public static AttendanceGateway getAttendanceGateway() {
        return new AttendancegatewayImpl();
    }

    public static MechanicGateway getMechanicGateway() {
        return new MechanicGatewayImpl();
    }

    public static BreakdownGateway getBreakdownGateway() {
        return new BreakdownGatewayImpl();
    }

    public static VehicleGateway getVehicleGateway() {
        return new VehicleGatewayImpl();
    }
}
