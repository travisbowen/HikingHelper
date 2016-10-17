package com.travisbowen.hikinghelper;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class FirstAidFragment extends ListFragment {

    public static final String TAG = "FirstAidFragment.TAG";
    ArrayList<FirstAidObject> firstAidArray = new ArrayList<>();

    public static FirstAidFragment newInstance() {
        FirstAidFragment firstAidFragment = new FirstAidFragment();

        return firstAidFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((FirstAidActivity)getActivity()).setActionBarTitle("First Aid");

        FirstAidObject obj1 = new FirstAidObject("Allergic Reaction",
                "1. Treat symptoms.  For mild allergy symptoms, such as hay fever or hives, give an over-the-counter (OTC) antihistamine.  For stuffy nose, give an OTC decongestant.  For itchy, watery eyes, use OTC allergy eye drops.  For itchy allergic rash, apply cold compresses and an OTC hydrocortisone cream.",
                "2. Follow up.  Watch for worsening symptoms, including signs of anaphylaxis.",
                "",
                "",
                "",
                "");

        FirstAidObject obj2 = new FirstAidObject("Animal Bites",
                "1. Stop bleeding.  Apply direct pressure until bleeding stops.",
                "2. Clean and protect.  For a wound or superficial scratch from an animal bite: Gently clean with soap and warm water. Rinse for several minutes after cleaning.  Apply antibiotic cream to reduce risk of infection, and cover with a sterile bandage.",
                "3. Get help.  Get medical help immediately for any animal bite that is more than a superficial scratch or if the animal was a wild animal or stray, regardless of the severity of the injury.  If the animal's owner is available, find out if the animal's rabies shots are up-to-date. Give this information to your health care provider.  If the animal was a stray or wild animal, call the local health department or animal control immediately.",
                "4. Follow up.  The health care provider will make sure the wound is thoroughly clean and may prescribe antibiotics.  If there is any risk of rabies infection, the health care provider will recommend anti-rabies treatment.  The person may require stitches, depending on the location and severity of the animal bite.  The person may also require a tetanus shot or booster.  The health care provider may recommend ibuprofen or acetaminophen for pain.",
                "",
                "");

        FirstAidObject obj3 = new FirstAidObject("Ankle Sprain",
                "1. Control swelling.  Remove ankle bracelets or toe rings.  Do RICE therapy: Rest the ankle. Use crutches if necessary.  Ice the ankle for 20 to 30 minutes several times a day for the first 2 days.  Compress by wrapping the ankle lightly -- not tightly -- with an Ace bandage or elastic ankle brace.  Elevate the ankle above heart level for the first 48 hours.",
                "2. Manage pain and inflammation.  Take ibuprofen (Advil, Motrin), acetaminophen (Tylenol), or aspirin for pain. But check with your doctor first if you have any medical conditions or take any other medicines.",
                "3. See a health care provider.  Make an appointment as soon as possible for any ankle sprain, mild or severe. Do not give aspirin to anyone younger than 18 unless told to do so by a doctor.",
                "",
                "",
                "");

        FirstAidObject obj4 = new FirstAidObject("Blisters",
                "1. For a Blister That Has Not Popped.  Try not to pop or drain.  Leave uncovered or cover loosely with a bandage.  Try not to put pressure on area. If blister is in a pressure area such as the bottom of the foot, put donut-shaped moleskin on it.",
                "2. For a Blister That Has Popped.  Wash the area with warm water and gentle soap. Do not use alcohol, hydrogen peroxide, or iodine.  Smooth down the skin flap that remains.  Apply antibiotic ointment.  Cover loosely with a sterile bandage or gauze.",
                "3. When to Drain a Blister.  To drain a blister that is large, painful, or in an awkward spot: Wash the area.  Sterilize a needle with rubbing alcohol or soap and water.  Make a small hole at the edge of the blister. Gently squeeze out the fluid.  Wash the blister again and pat dry. Don’t remove the skin over the blister.  Smooth down the skin flap.  Apply antibiotic ointment.  Cover loosely with a sterile bandage or gauze.",
                "4. Follow Up.  Change bandage daily and whenever it gets dirty or wet.  Avoid wearing shoes or doing the activity that caused the blister until it heals.  Wear thick socks or work gloves for blisters on feet or hands.  See a doctor for signs of infection, including pus, fever, red or warm skin around the blister, red streaks leading away from blister, swollen lymph glands, or increased pain or swelling, or if your last tetanus shot was more than 10 years ago.",
                "",
                "");

        FirstAidObject obj5 = new FirstAidObject("Blood in Urine",
                "1. Get Help.  Call your health care provider to set up a prompt appointment, even if you only see blood once in the urine. Inform the staff about the blood when you call.  Symptoms include blood clots or red, pink, orange, or brown color in urine.",
                "2. Monitor Symptoms.  Be ready to answer these questions for the health care provider.  What color was the blood in the urine?  Were there blood clots? If so, what shape?  Was there blood at the beginning or end of the urine stream or during the entire stream?  Was it painful for the person to urinate? Where was the pain located (for example, back, side, groin, or genital area)?",
                "3. Follow up with doctor if needed.",
                "",
                "",
                "");

        FirstAidObject obj6 = new FirstAidObject("Broken Arm",
                "1. Stop the Bleeding if Necessary.  Apply firm pressure to the wound area with a clean cloth until bleeding stops.  If bone is pushing through skin, do not touch it or try to put it back in place.",
                "2. Reduce Swelling.  Apply ice.  Elevate the arm above the heart, if possible.",
                "3. Immobilize Arm.  For less serious injuries: Cut away the sleeve if it cannot be removed without moving the injured arm.  If you can without moving the arm, carefully tape it to rolled-up newspaper or a ruler with first aid tape.",
                "4. See a Health Care Provider Immediately.",
                "",
                "");

        FirstAidObject obj7 = new FirstAidObject("Broken Finger",
                "1. Immobilize the Finger.  Tape the broken finger to an adjacent non-broken finger.",
                "2. Control Swelling.  Cool the finger by applying ice that is wrapped in a towel -- don't apply ice directly to the skin; it can cause a burn.",
                "3. Get Help.  Call a health care provider or go to a hospital emergency room immediately so the broken finger can be X-rayed and properly set. Without treatment, it may not heal properly and could lead to a permanent deformity.",
                "4. Treat Symptoms.  Use an over-the-counter pain medicine such as acetaminophen (Tylenol) or ibuprofen (Advil, Motrin).",
                "",
                "");

        FirstAidObject obj8 = new FirstAidObject("Broken Hand",
                "1. Stop Bleeding if Necessary.  Apply firm pressure with a clean cloth until bleeding stops.  If the bone is pushing through the skin, do not touch it or try to put it back in place.",
                "2. Control Swelling.  Apply an ice pack (do not put ice directly against the skin).  If possible, remove any jewelry immediately.",
                "3. Immobilize the Hand.  If the person's hand is numb or cold or the skin under the fingernails is blue, do not move the hand or arm. Otherwise: Have the person bend the arm at the elbow.  Do not try to straighten the hand if it bent or deformed.  Tie a splint on the lower arm with fabric or elastic bandages. Cardboard, rolled-up newspaper, or other stiff material can be used as a splint.  Make a sling and place the person's arm in it. Tie the sling around his or her neck.",
                "4. See a Health Care Provider Immediately.",
                "",
                "");

        FirstAidObject obj9 = new FirstAidObject("Broken Leg",
                "1. Reduce Swelling and Avoid Further Injury.  Keep the injured leg as still as possible. Do not let the person bear any weight on the leg.  Apply ice.  Keep the leg raised with pillows or cushions.",
                "2. Seek Medical Care Immediately.  Take the person to see a health care provider. If you think a thighbone is broken or you are unable to move the person, call 911 and have the person taken to the hospital.",
                "",
                "",
                "",
                "");

        FirstAidObject obj10 = new FirstAidObject("Burns",
                "1. Cool Burn.  Hold burned skin under cool (not cold) running water or immerse in cool water until pain subsides.  Use compresses if running water isn’t available.",
                "2. Protect Burn.  Cover with sterile, non-adhesive bandage or clean cloth.  Do not apply butter or ointments, which can cause infection.",
                "3. Treat Pain.  Give over-the-counter pain reliever such as ibuprofen (Advil, Motrin), acetaminophen (Tylenol), or naproxen (Aleve).",
                "4. When to See a Doctor.  Seek medical help if: You see signs of infection, like increased pain, redness, swelling, fever, or oozing.  The person needs tetanus or booster shot, depending on date of last injection. Tetanus booster should be given every 10 years.  Redness and pain last more than a few hours.  Pain worsens.",
                "",
                "");

        FirstAidObject obj11 = new FirstAidObject("Chafing",
                "1. Gently clean the chafed area with water and dry it thoroughly.",
                "2. After cleaning the area, apply a substance like petroleum jelly.",
                "3. If the area is very painful, swollen, bleeding, or crusted, your health care provider may recommend a medicated ointment.",
                "",
                "",
                "");

        FirstAidObject obj12 = new FirstAidObject("Chest Pain",
                "1. Treat With Nitroglycerin.  If the person gets chest pain and has been prescribed nitroglycerin: Dissolve 1 nitroglycerin tablet under the tongue.",
                "2. Wait 5 minutes.  If the person still has angina, call 911.",
                "3. If the person has not been prescribed nitroglycerin call 911.",
                "",
                "",
                "");

        FirstAidObject obj13 = new FirstAidObject("Concussion",
                "1. Prevent Swelling and Further Injury.  Have the person stop activity and rest.  Apply ice wrapped in a washcloth.",
                "2. Treat Symptoms.  For pain, take over-the-counter acetaminophen (Tylenol). Aspirin or ibuprofen (Advil, Motrin) may make bruising worse.",
                "3. Monitor Symptoms.  If possible, stay with the person for 24 hours.",
                "4. When to Call a Doctor.  Anyone with a suspected concussion should be seen by a doctor. Once discharged, seek immediate medical care again if any of these symptoms develop: A headache that seems to be getting worse.  Continued vomiting.  Increased drowsiness or dizziness.  Increased confusion.",
                "",
                "");

        FirstAidObject obj14 = new FirstAidObject("Constipation",
                "1. Increase Fluids.  For infants 4 months or older: add small amounts of fruit juice, such as prune, pear, or apple juices.  For children 1 year or older: offer fruit juices and more water.",
                "2. Increase Fiber.  For infants 4 months or older: add baby foods such as peas, beans, prunes, peaches, plums, and apricots.  For children 1 year or older: add fruits, vegetables such as peas, beans, and broccoli, and whole-grain foods such as brown rice, whole wheat bread, graham crackers. Four to five prunes a day is also a very good source of fiber.  Cut down on candies and sweets. Limit milk and cheese to 16-20 ounces.",
                "3. See pediatrician if problem continues.",
                "",
                "",
                "");

        FirstAidObject obj15 = new FirstAidObject("CPR for Adults",
                "1. Check Responsiveness.  Tap the person's shoulder and shout, Are you OK? Look for normal breathing. Call 911 if there is no response.  Start Hands-Only CPR.  Hands-Only CPR should not be used for adults whose cardiac arrest is due to drug overdose, near-drowning, or an unwitnessed cardiac arrest. In these cases, do a conventional CPR combination of chest compressions and rescue breathing.",
                "2. Do Chest Compressions.  Place the heel of your hand on the center of the person's chest.  Place the heel of your other hand on top of your first hand, lacing fingers together.  Keep arms straight and your shoulders directly over your hands.  Push hard and fast, compressing chest at least 2 inches.  Let chest rise completely before pushing down again.  Compress at least 100 times per minute.",
                "3. Stop Only if: The person starts breathing normally.  A trained responder or emergency help takes over.  You are too exhausted to continue.  There is an automated external defibrillator (AED) to use.",
                "4. Use an AED as Soon as One Is Available.",
                "",
                "");

        FirstAidObject obj16 = new FirstAidObject("Cuts and Bleeding",
                "1. Stop the Bleeding.  Apply direct pressure on the area.",
                "2. Clean and Protect.  Clean the area with warm water and gentle soap.  Apply an antibiotic ointment to reduce chance of infection.  Put a sterile bandage on the area. In some people, antibiotic ointments may cause a rash. If this happens, stop using the ointment.",
                "3. Call a Health Care Provider.",
                "",
                "",
                "");

        FirstAidObject obj17 = new FirstAidObject("Dehydration",
                "1. Replace Fluids.  For mild dehydration or while waiting for medical care for an adult with severe dehydration that is not due to heat stroke: The person should try to drink 2 quarts of fluid, such as water, juice, or sports drinks, in 2 to 4 hours. But it is better to drink small amounts of fluid often, because drinking too much fluid at once can bring on vomiting.  The person should drink at least 10 glasses of liquid a day to replace lost fluids.  If the person is elderly, fluid replacement may need to be done slowly. Consult a doctor.  If the person is vomiting, try ice chips, popsicles, and small sips of fluid.  If the person is recovering from diarrhea, consider that some sports drinks contain a lot of sugar, which can worsen diarrhea.",
                "2. When to Call a Doctor for Mild Dehydration.  Seek medical help if: The person’s symptoms get worse or don't improve within 24 hours.  The person is elderly.  You think a prescription medication such as a diuretic caused the dehydration.",
                "",
                "",
                "",
                "");

        FirstAidObject obj18 = new FirstAidObject("Diarrhea",
                "1. Give an adult plenty of clear fluid, like fruit juices, soda, sports drinks and clear broth. Avoid milk or milk-based products, alcohol, apple juice, and caffeine while you have diarrhea and for 3-5 days after you get better. They may make diarrhea worse.  Give a child or infant frequent sips of a rehydration solution such as Pedialyte, Ceralyte, or Infalyte. Do not add salt tablets to a baby’s bottle.  Make sure the person drinks more fluids than they are losing through diarrhea. If they are unable to keep up with their losses, call a doctor.",
                "2. Rest.  Have the person rest as needed and avoid strenuous exercise. Keep a sick child home from school or day care.",
                "3. Ease Into Eating.  Feed an infant or child easily digested foods; the BRAT diet (bananas, rice, applesauce, and toast) is a good choice as soon as they can tolerate food.  For an adult, add semisolid and low-fiber foods gradually as diarrhea stops. Avoid spicy, greasy, or fatty foods.",
                "",
                "",
                "");

        FirstAidObject obj19 = new FirstAidObject("Dizziness",
                "1. Treat Symptoms.  The person should sit down or lie still.  If the person gets light-headed when standing up, the person should stand up slowly.  Avoid sudden changes in position.  If the person is thirsty, have him or her drink fluids.  Avoid bright lights.",
                "2. Call a health care professional if: This is the first time the person has been dizzy.  The dizziness is different than before or doesn't go away quickly.",
                "",
                "",
                "",
                "");

        FirstAidObject obj20 = new FirstAidObject("Drowning",
                "1. Get help.",
                "2. Move the person out of the water.",
                "3. Check for breathing.",
                "4. If the person is not breathing, check for pulse.",
                "5. If There is No Pulse, Start CPR.  Carefully place person on back.  For an adult or child, place the heel of one hand on the center of the chest at the nipple line. You can also push with one hand on top of the other. For an infant, place two fingers on the breastbone.  For an adult or child, press down about 2 inches. Make sure not to press on ribs. For an infant, press down about 1 and 1/2 inches. Make sure not to press on the end of the breastbone.  Do 30 chest compressions, at the rate of 100 per minute or more. Let the chest rise completely between pushes.  Check to see if the person has started breathing.",
                "");

        FirstAidObject obj21 = new FirstAidObject("Frostbite",
                "1. Seek Medical Care Promptly.  See a doctor or go to a hospital emergency room.",
                "2. Restore Warmth.  Until you can see a doctor: Get the person to a warm place and remove any wet clothing.  Unless absolutely necessary, the person should not walk on frostbitten toes or feet.  Do not rewarm the skin until you can keep it warm. Warming and then re-exposing the frostbitten area to cold air can cause worse damage.  Gently warm the area in warm water (not hot) or with wet heat until the skin appears red and warm.  If no water is nearby, breathe on the area through cupped hands and hold it next to your body.  Do not use direct heat from heating pads, radiator, or fires.  Do not rub or massage the skin or break blisters.",
                "3. Bandage the Area.  Loosely apply dry, sterile dressings.  Put gauze or clean cotton balls between fingers or toes to keep them separated.",
                "",
                "",
                "");

        FirstAidObject obj22 = new FirstAidObject("Heart Attack",
                "1. Wait for Emergency Help to Arrive.  Do not drive to the hospital unless you have no other option.  Ambulance personnel can start care as soon as they arrive.  If there is no history of aspirin allergy or bleeding, emergency response may ask the person to chew one 325 mg aspirin slowly.",
                "2. Follow Up.  At the hospital, an emergency department doctor will examine the person and run tests to see if chest pain stems from a heart attack or another cause. Tests may include an electrocardiogram (ECG), chest X-ray, and blood tests.  Inform the person's doctor about the chest pain and ER visit.",
                "",
                "",
                "",
                "");

        FirstAidObject obj23 = new FirstAidObject("Heat Stroke",
                "1. Call 911.  Heat stroke is a medical emergency. Seek immediate emergency care if you think someone might have heat stroke.",
                "2. Lower Body Temperature Quickly While Waiting for Emergency Services to Arrive.  Get the person into air conditioning if possible or out of the sun and into the shade.  Spray the person with cool water, or apply cold wet cloths or ice packs to the armpits, neck, and groin. Fan air across the person to increase cooling. These methods help cool the person quickly.  Do not give the person anything to drink if the person is not alert or is vomitting.",
                "3. Treat Symptoms.  If the person experiences seizures, keep him or her safe from injury.  If the person vomits, turn the person on his or her side to keep the airway open.",
                "",
                "",
                "");

        FirstAidObject obj24 = new FirstAidObject("Insect Sting Allergy",
                "1. Remove the Stinger.  Scrape the area with a fingernail or use tweezers to remove it.  Don't pinch the stinger -- that can inject more venom.",
                "2. Control Swelling.  Ice the area.  If you were stung on your arm or leg, elevate it.  Remove any tight-fitting jewelry from the area of the sting. As it swells, rings or bracelets might be difficult to remove.",
                "3. Treat Symptoms.  For pain, take an over-the-counter painkiller like acetaminophen or ibuprofen. Do not give aspirin to anyone under age 18.  For itchiness, take an antihistamine. You can also apply a mixture of baking soda and water or calamine lotion.",
                "",
                "",
                "");

        FirstAidObject obj25 = new FirstAidObject("Insect Stings and Bites",
                "1. Remove the Stinger (for Honeybee Stings).  Honeybees are the only insects that leave a stinger in the skin. Scrape the area with a fingernail or credit card to remove it.  Don't pinch the stinger with your fingers or tweezers -- that can inject more venom.",
                "2. Clean the Area.  Wash the bite or sting with mild soap and water.",
                "3. Treat Symptoms.  Remove any tight jewelry from the area of the bite or sting. It could be hard to get off once the area swells.  Ice the area for 10 minutes and then remove the ice for 10 minutes. Then repeat.  If the sting was on an arm or leg, elevate the area.  Pain relievers that are formulated for babies or children, such as acetaminophen (Tylenol) or ibuprofen (Advil, Motrin) can help. Be sure to follow the dosing instructions on the bottle. If your child is under the recommended age, call a pediatrician.  An antihistamine formulated for children may help with swelling and itch. Call a pediatrician before using an antihistamine in infants or toddlers.  Apply a mixture of baking soda and water or calamine lotion for itch.",
                "",
                "",
                "");

        FirstAidObject obj26 = new FirstAidObject("Muscle Cramps",
                "1. Stretch and massage the muscle.",
                "2. Try using an ice or cold pack. Always keep a cloth between your skin and the ice pack.",
                "3. Take an over-the-counter pain medicine, such as acetaminophen (Tylenol), ibuprofen (Advil, Motrin), or naproxen (Aleve).",
                "4. Drink plenty of fluids. Sports drinks, such as Gatorade, will often help leg cramps.",
                "5. If your doctor prescribes medicines for muscle cramps, take them exactly as prescribed. Call your doctor if you have any problems with your medicine.",
                "");

        FirstAidObject obj27 = new FirstAidObject("Poison Ivy, Oak, or Sumac",
                "1. Wash Exposed Area.  Wash with warm soap and water.  Washing within 10 minutes can significantly reduce the chance of an allergic reaction.",
                "2. Remove Contaminated Clothing.  Plant oil can continue to spread from clothing and shoes.",
                "3. Ease Itching and Discomfort.  Apply cool compresses for 15 to 30 minutes at a time.  Avoid topical antihistamines, anesthetics like benzocaine, and antibiotic ointments, all of which may make skin more sensitive.  Have the person take oatmeal baths.  Apply calamine lotion.  If itchiness makes sleep difficult, give an oral antihistamine.",
                "4. When to See a Doctor.  Get medical help if rash covers a large part of the person's body, or if the person has blisters or can't sleep.",
                "",
                "");

        FirstAidObject obj28 = new FirstAidObject("Snakebite",
                "1. Note the Snake's Appearance.  Be ready to describe the snake to emergency staff.",
                "2. Protect the Person.  While waiting for medical help: Move the person beyond striking distance of the snake.  Have the person lie down with wound below the heart.  Keep the person still to keep venom from spreading.  Cover the wound with loose, sterile bandage.  Do not: Cut a bite wound.  Attempt to suck out venom.  Apply tourniquet, ice, or water.  Give the person alcohol or caffeinated drinks.",
                "",
                "",
                "",
                "");

        FirstAidObject obj29 = new FirstAidObject("Sunburn",
                "1. Rehydrate.  Replace body fluids with water, juice, or sports drinks.",
                "2. Treat Symptoms.  Apply aloe or over-the-counter moisturizing lotion to skin as directed.  To soothe and cool skin, bathe in lukewarm water or apply cool compresses to the area.  For pain, take ibuprofen (Advil, Motrin) or acetaminophen (Tylenol).",
                "",
                "",
                "",
                "");

        FirstAidObject obj30 = new FirstAidObject("Tick Removal",
                "1. Remove Tick.  If the tick is attached to the person's skin, remove it immediately: Wearing gloves, grasp the tick with clean tweezers as close to the skin as possible to remove the head and mouthparts.  Pull the tick straight out gently and steadily. Do not twist.  Do not try to remove tick with a hot match or petroleum jelly. This could cause the tick to regurgitate infected fluids into the wound.  Save the tick in a container of alcohol to show the doctor.",
                "2. Cleanse and Protect the Area.  Wash hands and clean the bite area with warm water and gentle soap.  Apply alcohol to the bite wound to prevent infection.",
                "3. See a Health Care Provider.  See a health care provider immediately if the tick has burrowed into skin or if the head, mouthparts, or other tick remains cannot be removed.",
                "",
                "",
                "");

//        FirstAidObject obj28 = new FirstAidObject("",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "");

        firstAidArray.add(obj1);
        firstAidArray.add(obj2);
        firstAidArray.add(obj3);
        firstAidArray.add(obj4);
        firstAidArray.add(obj5);
        firstAidArray.add(obj6);
        firstAidArray.add(obj7);
        firstAidArray.add(obj8);
        firstAidArray.add(obj9);
        firstAidArray.add(obj10);
        firstAidArray.add(obj11);
        firstAidArray.add(obj12);
        firstAidArray.add(obj13);
        firstAidArray.add(obj14);
        firstAidArray.add(obj15);
        firstAidArray.add(obj16);
        firstAidArray.add(obj17);
        firstAidArray.add(obj18);
        firstAidArray.add(obj19);
        firstAidArray.add(obj20);
        firstAidArray.add(obj21);
        firstAidArray.add(obj22);
        firstAidArray.add(obj23);
        firstAidArray.add(obj24);
        firstAidArray.add(obj25);
        firstAidArray.add(obj26);
        firstAidArray.add(obj27);
        firstAidArray.add(obj28);
        firstAidArray.add(obj29);
        firstAidArray.add(obj30);
    }


    @Override
    public void onListItemClick(ListView listView, View view, int pos, long id) {
        super.onListItemClick(listView, view, pos, id);

        FirstAidObject customObject = (FirstAidObject) listView.getAdapter().getItem(pos);

        Intent intent = new Intent(getActivity(), FirstAidActivityDetails.class);

        intent.putExtra("Name", customObject.getName());
        intent.putExtra("Step1", customObject.getSteps1());
        intent.putExtra("Step2", customObject.getSteps2());
        intent.putExtra("Step3", customObject.getSteps3());
        intent.putExtra("Step4", customObject.getSteps4());
        intent.putExtra("Step5", customObject.getSteps5());
        intent.putExtra("Step6", customObject.getSteps6());

        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();

        if (firstAidArray != null){
            ArrayAdapter<FirstAidObject> listAdapter = new ArrayAdapter<FirstAidObject>(getActivity(), android.R.layout.simple_list_item_1, firstAidArray);
            setListAdapter(listAdapter);
        }
    }
}
