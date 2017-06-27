package by.htp.ahremenko.service.exception;

import by.htp.ahremenko.dao.exception.DAOException;

public class ServiceException extends DAOException {
		private static final long serialVersionUID = 1L;
		
		public ServiceException () {
			super();
		}
		
		public ServiceException (String msg) {
			super(msg);
		}

		public ServiceException (Exception e) {
			super(e);
		}
		
		public ServiceException (String msg, Exception e) {
			super( msg, e);
		}
}
