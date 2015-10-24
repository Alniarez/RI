package uo.ri.amp.conf;

import uo.ri.amp.persistence.AttendanceGateway;
import uo.ri.amp.persistence.CertificateGateway;
import uo.ri.amp.persistence.GradeGateway;
import uo.ri.amp.persistence.impl.AttendancegatewayImpl;
import uo.ri.amp.persistence.impl.CertificateGatewayImpl;
import uo.ri.amp.persistence.impl.GradeGatewayImpl;

/**
 * Created by Jorge.
 */
public class PersistenceFactory {

    public static GradeGateway getGradeGateway() {
        return new GradeGatewayImpl();
    }

    public static AttendanceGateway geAttendanceGateway(){
        return new AttendancegatewayImpl();
    }

    public static CertificateGateway getCertificateGateway(){
        return new CertificateGatewayImpl();
    }
}
