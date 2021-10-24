//
// ex: set ro:
// DO NOT EDIT.
// generated by smc (http://smc.sourceforge.net/)
// from file : AppClass.sm
//

#ifndef APPCLASS_SM_H
#define APPCLASS_SM_H


#define SMC_USES_IOSTREAMS

#include <statemap.h>

// Forward declarations.
class Map1;
class Map1_Start;
class Map1_NUMBER;
class Map1_PLUS;
class Map1_DIGIT;
class Map1_MESSAGE;
class Map1_SMS_MESSAGE;
class Map1_SMS_MESSAGE_b;
class Map1_SMS_MESSAGE_o;
class Map1_SMS_MESSAGE_d;
class Map1_SMS_MESSAGE_y;
class Map1_SMS_TEXT;
class Map1_Default;
class AppClassState;
class AppClassContext;
class AppClass;

class AppClassState :
    public statemap::State
{
public:

    AppClassState(const char * const name, const int stateId)
    : statemap::State(name, stateId)
    {};

    virtual void Entry(AppClassContext&) {};
    virtual void Exit(AppClassContext&) {};

    virtual void EOS(AppClassContext& context);
    virtual void digit(AppClassContext& context, char symbol);
    virtual void next_state(AppClassContext& context, std::string str);

protected:

    virtual void Default(AppClassContext& context);
};

class Map1
{
public:

    static Map1_Start Start;
    static Map1_NUMBER NUMBER;
    static Map1_PLUS PLUS;
    static Map1_DIGIT DIGIT;
    static Map1_MESSAGE MESSAGE;
    static Map1_SMS_MESSAGE SMS_MESSAGE;
    static Map1_SMS_MESSAGE_b SMS_MESSAGE_b;
    static Map1_SMS_MESSAGE_o SMS_MESSAGE_o;
    static Map1_SMS_MESSAGE_d SMS_MESSAGE_d;
    static Map1_SMS_MESSAGE_y SMS_MESSAGE_y;
    static Map1_SMS_TEXT SMS_TEXT;
};

class Map1_Default :
    public AppClassState
{
public:

    Map1_Default(const char * const name, const int stateId)
    : AppClassState(name, stateId)
    {};

};

class Map1_Start :
    public Map1_Default
{
public:
    Map1_Start(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void EOS(AppClassContext& context);
    virtual void next_state(AppClassContext& context, std::string str);
};

class Map1_NUMBER :
    public Map1_Default
{
public:
    Map1_NUMBER(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_PLUS :
    public Map1_Default
{
public:
    Map1_PLUS(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_DIGIT :
    public Map1_Default
{
public:
    Map1_DIGIT(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_MESSAGE :
    public Map1_Default
{
public:
    Map1_MESSAGE(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void EOS(AppClassContext& context);
    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_MESSAGE :
    public Map1_Default
{
public:
    Map1_SMS_MESSAGE(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_MESSAGE_b :
    public Map1_Default
{
public:
    Map1_SMS_MESSAGE_b(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_MESSAGE_o :
    public Map1_Default
{
public:
    Map1_SMS_MESSAGE_o(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_MESSAGE_d :
    public Map1_Default
{
public:
    Map1_SMS_MESSAGE_d(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_MESSAGE_y :
    public Map1_Default
{
public:
    Map1_SMS_MESSAGE_y(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void digit(AppClassContext& context, char symbol);
};

class Map1_SMS_TEXT :
    public Map1_Default
{
public:
    Map1_SMS_TEXT(const char * const name, const int stateId)
    : Map1_Default(name, stateId)
    {};

    virtual void EOS(AppClassContext& context);
    virtual void digit(AppClassContext& context, char symbol);
};

class AppClassContext :
    public statemap::FSMContext
{
public:

    explicit AppClassContext(AppClass& owner)
    : FSMContext(Map1::Start),
      _owner(owner)
    {};

    AppClassContext(AppClass& owner, const statemap::State& state)
    : FSMContext(state),
      _owner(owner)
    {};

    virtual void enterStartState()
    {
        getState().Entry(*this);
        return;
    }

    inline AppClass& getOwner()
    {
        return (_owner);
    };

    inline AppClassState& getState()
    {
        if (_state == NULL)
        {
            throw statemap::StateUndefinedException();
        }

        return dynamic_cast<AppClassState&>(*_state);
    };

    inline void EOS()
    {
        setTransition("EOS");
        getState().EOS(*this);
        setTransition(NULL);
    };

    inline void digit(char symbol)
    {
        setTransition("digit");
        getState().digit(*this, symbol);
        setTransition(NULL);
    };

    inline void next_state(std::string str)
    {
        setTransition("next_state");
        getState().next_state(*this, str);
        setTransition(NULL);
    };

private:
    AppClass& _owner;
};


#endif // APPCLASS_SM_H

//
// Local variables:
//  buffer-read-only: t
// End:
//
