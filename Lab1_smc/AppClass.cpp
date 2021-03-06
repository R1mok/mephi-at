//
// The contents of this file are subject to the Mozilla Public
// License Version 1.1 (the "License"); you may not use this file
// except in compliance with the License. You may obtain a copy
// of the License at http://www.mozilla.org/MPL/
// 
// Software distributed under the License is distributed on an
// "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
// implied. See the License for the specific language governing
// rights and limitations under the License.
// 
// The Original Code is State Machine Compiler (SMC).
// 
// The Initial Developer of the Original Code is Charles W. Rapp.
// Portions created by Charles W. Rapp are
// Copyright (C) 2000 - 2009. Charles W. Rapp.
// All Rights Reserved.
// 
// Contributor(s): 
//
// Class
//	AppClass
//
// Inline Member Functions
//	AppClass()				   - Default constructor.
//	CheckString(const char *)  - Is this string acceptable?
//
// RCS ID
// $Id$
//
// CHANGE LOG
// $Log$
// Revision 1.10  2015/08/02 19:44:34  cwrapp
// Release 6.6.0 commit.
//
// Revision 1.9  2014/09/07 17:16:44  fperrad
// explicit condition
//
// Revision 1.8  2014/09/06 19:53:15  fperrad
// remove hard tab
//
// Revision 1.7  2014/09/06 09:02:18  fperrad
// pragma only for MS compiler
//
// Revision 1.6  2014/07/12 10:48:49  fperrad
// remove _rcs_id
//
// Revision 1.5  2009/03/01 18:20:37  cwrapp
// Preliminary v. 6.0.0 commit.
//
// Revision 1.4  2005/05/28 13:31:16  cwrapp
// Updated C++ examples.
//
// Revision 1.0  2003/12/14 19:06:42  charlesr
// Initial revision
//

#ifdef _MSC_VER
#pragma warning(disable: 4355)
#endif

#include "AppClass.h"

AppClass::AppClass()
#ifdef CRTP
: isAcceptable(false)
  sms(false)
#else
: _fsm(*this),
  isAcceptable(false),
  sms(false)
#endif
{
#ifdef FSM_DEBUG
#ifdef CRTP
    setDebugFlag(true);
#else
    _fsm.setDebugFlag(true);
#endif
#endif
}

bool AppClass::CheckString(std::string theString)
{
#ifdef CRTP
    enterStartState();

    /* while (theString != '\0')
    {
        switch (theString)
        {
        case '0':
            Zero();
            break;

        case '1':
            One();
            break;

        default:
            Unknown();
            break;
        }
        ++theString;
    }
    */
    //std::string prefixStr(theString, 0, 3);
    //if (prefixStr == "tel") {
    //    tel();
    //}
    //else if (prefixStr == "sms") {
    //    sms();
    //}
    //else if (prefixStr == "fax") {
    //    fax();
    //}
    //else {
    //    Unknown();
    //}
    //if (theString[3] != ':') {
    //    Unknown();
    //}
    //int count = 0;
    //std::string curString(theString, 0, 3 + 1 + 1);
    //while (curString[0] != ';') {
    //    number();
    //    if (curString[0] == ',')
    //        curString = curString.substr(1, curString.size() - 1);
    //    for (int i = 0; curString[i] != ',' || curString[i] != ';'; ++i) {
    //        if (curString[0] != '+') {
    //            Unknown();
    //        }
    //        else {
    //            curString = curString.substr(1, curString.size() - 1);
    //        }
    //        if (curString[i] >= '0' && curString[i] <= '9') {
    //            ++count;
    //            digit();
    //        }
    //        else {
    //            Unknown();
    //        }
    //        if (count > 11) {
    //            Unknown();
    //        }
    //    }
    //    curString = curString.substr(11, curString.size() - 11);
    //}
    //if (curString[1] != '?') {
    //    Unknown();
    //}
    //if (prefixStr == "sms") {
    //    Message();
    //}
    //else {
    //    EOS();
    //}
    //curString = curString.substr(2, curString.size() - 2);
    //std::string body(curString, 0, 6);
    //if (body != "body=") {
    //    Unknown();
    //}
    //else {
    //    curString = curString.substr(6, curString.size() - 6);
    //}
    //int count = 0;
    //for (int i = 0; i < curString.size(); ++i) {
    //    if ((curString[i] <= 'A' && curString[i] >= 'Z') || (curString[i] <= 'a' && curString[i] >= 'z') ||
    //        (curString[i] <= '9' && curString[i] >= '0') || (curString[i] == '%' || curString[i] == ',' || curString[i] == '.')
    //        || curString[i] == '!' || curString[i] == '?') {
    //        ++count;
    //        CorrectMessage();
    //    }
    //    else {
    //        Unknown();
    //    }
    //}
    //if (count > 64) {
    //    Unknown();
    //}
    //// end of string has been reached - send the EOS transition.
    //EOS();
#else
    _fsm.enterStartState();
    _fsm.EOS();
    std::string prefixStr(theString, 0, 4); 
    _fsm.next_state(prefixStr);
    std::string curString = theString.substr(4, theString.size() - 4);
    for (int i = 0; i < curString.size(); ++i) {
        if (correctStream)
            _fsm.digit(curString[i]);
        else break;
    }
    return isAcceptable;
#endif
}
