/**
 *
 */
package es.um.sisdist.backend.dao;

import es.um.sisdist.backend.dao.user.IUserDAO;
import es.um.sisdist.backend.dao.user.MongoUserDAO;
import es.um.sisdist.backend.dao.user.SQLUserDAO;

/**
 * @author dsevilla
 *
 */
public class DAOFactoryImpl implements IDAOFactory
{
	
	// crear usuario
    @Override
    public IUserDAO createSQLUserDAO()
    {
        return new SQLUserDAO();
    }

    @Override
    public IUserDAO createMongoUserDAO()
    {
        return new MongoUserDAO();
    }
    
    // eliminar usuario

    // falta implementar 
	@Override
	public boolean removeSQLUserDAO() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMongoUserDAO() {
		// TODO Auto-generated method stub
		return false;
	}
}
