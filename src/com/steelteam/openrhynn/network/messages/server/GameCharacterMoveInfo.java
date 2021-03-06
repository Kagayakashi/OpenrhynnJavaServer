/*
MIT License
-----------

Copyright (c) 2019 Ivan Yurkov (MB "Stylo tymas" http://steel-team.net)
Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
*/
package com.steelteam.openrhynn.network.messages.server;

import com.steelteam.openrhynn.network.messages.ORMessageIDs;
import com.steelteam.openrhynn.network.messages.ORMessage;

public class GameCharacterMoveInfo {

    private ORMessage _message = null;

    /* custom start */
    private int _x = 0;
    private int _y = 0;
    private int _direction = 0;
    private int _objectId = 0;
    /* custom end */

    public GameCharacterMoveInfo(int x, int y, int direction, int objectId) {
        _message = new ORMessage(getMessageId());
        /* custom start */
        _x = x;
        _y = y;
        _direction = direction;
        _objectId = objectId;

        _message.writeInt2(_x);
        _message.writeInt2(_y);
        _message.writeByte((byte)_direction);
        _message.writeInt4(_objectId);

        /* custom end */
    }

    public GameCharacterMoveInfo(ORMessage message) {
        _message = message;
        /* custom start */
        _x = message.readIntFrom2();
        _y = message.readIntFrom2();
        _direction = message.readByte();
        _objectId = message.readIntFrom4();
        /* custom end */
    }

    public int getMessageId() {
        return ORMessageIDs.MSGID_GAME_CHARACTER_MOVE_INFO;
    }

    public ORMessage getData() {
        return _message;
    }

    /* message custom */

    public int getX() {
        return _x;
    }
    public int getY() {
        return _y;
    }
    public int getDirection() {
        return _direction;
    }

    public int getObjectId() {
        return _objectId;
    }

    /* message custom end */
}
