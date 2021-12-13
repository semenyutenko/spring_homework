package base.service;

import base.domain.ITicket;

public interface IChecker {
    boolean isRight(ITicket ticket, String answer);
}
