import { useSelector, useDispatch } from 'react-redux';
import * as Derived from '../utils/derivedAttrs';
import { incrementAttribute, decrementAttribute } from '../store/playerSlice';

export default function Player({editMode}) {

    const dispatch = useDispatch();
    const player = useSelector(state => state.player); 

    const initiative = Derived.initiative(player.current.attributes);
    const attack = Derived.attack(player.current.attributes);
    const defense = Derived.defense(player.current.attributes);
    const aim = Derived.aim(player.current.attributes);

    function handleIncrease(attrName) {
        dispatch(incrementAttribute(attrName));
    }

    function handleDecrease(attrName) {
        dispatch(decrementAttribute(attrName));
    }

    return (
        <>
            <div className='flex flex-row'>
                <div id='attributes'
                    className='mt-4 ml-4 flex justify-start flex-col'>
                    <h3 className="text-violet-200 w-60 mb-2 font-semibold text-2xl"> Attributes </h3>
                    <ul>
                        {player.current.attributes.map(attr => (

                            <li key={attr.id}
                                className="flex items-center justify-between w-52 py-1 text-violet-200 hover:bg-violet-950"
                            >
                                {/* Attribute name (left) */}
                                <div className="w-20 text-left text-lg">{attr.name}</div>

                                {/* Control group (center) */}
                                <div className="flex items-center justify-center gap-1 w-20">
                                    {/* Minus button (always takes space) */}
                                    {editMode ? (
                                        <button onClick={() => handleDecrease(attr.name)}
                                            className="w-6 h-6 flex items-center justify-center rounded-full bg-violet-700 text-red-500 text-sm font-bold leading-none hover:bg-violet-800 transition"
                                        >
                                            −
                                        </button>
                                    ) : (
                                        <div className="w-6 h-6" /> // Empty placeholder to preserve layout
                                    )}

                                    {/* Attribute value */}
                                    <div className="w-6 text-center text-lg">{attr.value}</div>

                                    {/* Plus button (always takes space) */}
                                    {editMode ? (
                                        <button onClick={() => handleIncrease(attr.name)}
                                            className="w-6 h-6 flex items-center justify-center rounded-full bg-violet-700 text-green-500 text-sm font-bold leading-none hover:bg-violet-800 transition"
                                        >
                                            +
                                        </button>
                                    ) : (
                                        <div className="w-6 h-6" />
                                    )}
                                </div>
                            </li>

                        ))}
                    </ul>
                </div>

                <div id='derived-attributes'
                    className='mt-4 ml-4 flex justify-start flex-col'>
                    <h3 className="text-violet-200 w-50 mb-2 ml-4 font-semibold text-2xl"> Derived attributes </h3>
                    <ul className="text-violet-200 w-50 mb-2 ml-8">
                        <li key="initiative" className='text-violet-200 flex justify-between w-34 py-0.5 mr-4 hover:bg-violet-950 text-lg'>
                            <div > Initiative </div>
                            <div > {initiative} </div>
                        </li>
                        <li key="attack" className='text-violet-200 flex justify-between w-34 py-0.5 mr-4 hover:bg-violet-950 text-lg'>
                            <div > Attack </div>
                            <div > {attack} </div>
                        </li>
                        <li key="defense" className='text-violet-200 flex justify-between w-34 py-0.5 mr-4 hover:bg-violet-950 text-lg'>
                            <div > Defense </div>
                            <div > {defense} </div>
                        </li>
                        <li key="aim" className='text-violet-200 flex justify-between w-34 py-0.5 mr-4 hover:bg-violet-950 text-lg'>
                            <div > Aim </div>
                            <div > {aim} </div>
                        </li>
                    </ul>
                </div>
            </div>
        </>

    )
}