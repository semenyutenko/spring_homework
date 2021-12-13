package base.service;

import base.domain.ITicket;

public class UsualChecker implements IChecker {
    @Override
    public boolean isRight(ITicket ticket, String answer) {
        return ticket.getAnswer().equals(answer);
    }
}
