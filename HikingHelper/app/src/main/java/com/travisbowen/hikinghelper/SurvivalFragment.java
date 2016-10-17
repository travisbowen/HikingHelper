package com.travisbowen.hikinghelper;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class SurvivalFragment extends ListFragment {

    public static final String TAG = "SurvivalFragment.TAG";
    ArrayList<SurvivalObject> survivalArray = new ArrayList<>();


    public static SurvivalFragment newInstance() {
        SurvivalFragment survivalFragment = new SurvivalFragment();

        return survivalFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SurvivalActivity)getActivity()).setActionBarTitle("Survival");

        SurvivalObject obj1 = new SurvivalObject("Clothing and Insulation",
                "1. Parachute Assembly - Consider the entire parachute assembly as a resource. Use every piece of material and hardware, to include the canopy, suspension lines, connector snaps, and parachute harness. Before disassembling the parachute, consider all of your survival requirements and plan to use different portions of the parachute accordingly. For example, consider shelter requirements, need for a rucksack, and so on, in addition to clothing or insulation needs.",
                "2. Animal Skins - The selection of animal skins in a survival situation will most often be limited to what you manage to trap or hunt. However, if there is an abundance of wildlife, select the hides of larger animals with heavier coats and large fat content. Do not use the skins of infected or diseased animals if at all possible. Since they live in the wild, animals are carriers of pests such as ticks, lice, and fleas. Because of these pests, use water to thoroughly clean any skin obtained from any animal. If water is not available, at least shake out the skin thoroughly. As with rawhide, lay out the skin, and remove all fat and meat. Dry the skin completely. Use the hind quarter joint areas to make shoes and mittens or socks. Wear the hide with the fur to the inside for its insulating factor.",
                "3. Plant Fiber - Several plants are sources of insulation from cold. Cattail is a marshland plant found along lakes, ponds, and the backwaters of rivers. The fuzz on the tops of the stalks forms dead air spaces and makes a good down-like insulation when placed between two pieces of material. Milkweed has pollenlike seeds that act as good insulation. The husk fibers from coconuts are very good for weaving ropes and, when dried, make excellent tinder and insulation.",
                "",
                "",
                "",
                "",
                "");

        SurvivalObject obj2 = new SurvivalObject("Crossing Rapids",
                "1. If necessary, you can safely cross a deep, swift river or rapids. To swim across a deep, swift river, swim with the current, never fight it. Try to keep your body horizontal to the water. This will reduce the danger of being pulled under.",
                "2. In fast, shallow rapids, lie on your back, feet pointing downstream, finning your hands alongside your hips. This action will increase buoyancy and help you steer away from obstacles. Keep your feet up to avoid getting them bruised or caught by rocks.",
                "3. In deep rapids, lie on your stomach, head downstream, angling toward the shore whenever you can. Watch for obstacles and be careful of backwater eddies and converging currents, as they often contain dangerous swirls. Converging currents occur where new watercourses enter the river or where water has been diverted around large obstacles such as small islands.",
                "4. To ford a swift, treacherous stream, apply the following steps: Remove your pants and shirt to lessen the water's pull on you. Keep your footgear on to protect your feet and ankles from rocks. It will also provide you with firmer footing.",
                "5. Tie your pants and other articles to the top of your rucksack or in a bundle, if you have no pack. This way, if you have to release your equipment, all your articles will be together. It is easier to find one large pack than to find several small items.",
                "6. Carry your pack well up on your shoulders and be sure you can easily remove it, if necessary. Not being able to get a pack off quickly enough can drag even the strongest swimmers under.",
                "7. Find a strong pole about 7.5 centimeters in diameter and 2.1 to 2.4 meters long to help you ford the stream. Grasp the pole and plant it firmly on your upstream side to break the current. Plant your feet firmly with each step, and move the pole forward a little downstream from its previous position, but still upstream from you. With your next step, place your foot below the pole. Keep the pole well slanted so that the force of the current keeps the pole against your shoulder.",
                "8. Cross the stream so that you will cross the downstream current at a 45-degree angle.");

        SurvivalObject obj3 = new SurvivalObject("Crossing Rivers and Streams",
                "1. You can apply almost every description to rivers and streams. They may be shallow or deep, slow or fast moving, narrow or wide. Before you try to cross a river or stream, develop a good plan.",
                "2. Your first step is to look for a high place from which you can get a good view of the river or stream. From this place, you can look for a place to cross. If there is no high place, climb a tree.",
                "3. A level stretch where it breaks into several channels. Two or three narrow channels are usually easier to cross than a wide river.",
                "4. A shallow bank or sandbar. If possible, select a point upstream from the bank or sandbar so that the current will carry you to it if you lose your footing.",
                "5. A course across the river that leads downstream so that you will cross the current at about a 45-degree angle.",
                "",
                "",
                "");

        SurvivalObject obj4 = new SurvivalObject("Eating Utensils",
                "1. Bowls - Use wood, bone, horn, bark, or other similar material to make bowls. To make wooden bowls, use a hollowed out piece of wood that will hold your food and enough water to cook it in. Hang the wooden container over the fire and add hot rocks to the water and food. Remove the rocks as they cool and add more hot rocks until your food is cooked.  You can also use this method with containers made of bark or leaves. However, these containers will burn above the waterline unless you keep them moist or keep the fire low.",
                "2. Forks, Knives, Spoons - Carve forks, knives, and spoons from nonresinous woods so that you do not get a wood resin aftertaste or do not taint the food. Nonresinous woods include oak, birch, and other hardwood trees.",
                "3. Pots - You can make pots from turtle shells or wood. As described with bowls, using hot rocks in a hollowed out piece of wood is very effective. Bamboo is the best wood for making cooking containers.",
                "4. Water Bottle - Make water bottles from the stomachs of larger animals. Thoroughly flush the stomach out with water, then tie off the bottom. Leave the top open, with some means of fastening it closed.",
                "",
                "",
                "",
                "");

        SurvivalObject obj5 = new SurvivalObject("Fire Starting",
                "1. Lighter - items we normally think of to start a fire.",
                "2. Matches - Make sure these matches are waterproof. Also, store them in a waterproof container along with a dependable striker pad.",
                "3. Convex Lens - Use this method only on bright, sunny days. The lens can come from binoculars, camera, telescopic sights, or magnifying glasses. Angle the lens to concentrate the sun's rays on the tinder. Hold the lens over the same spot until the tinder begins to smolder. Gently blow or fan the tinder into flame, and apply it to the fire lay.",
                "4. Metal Match - Place a flat, dry leaf under your tinder with a portion exposed. Place the tip of the metal match on the dry leaf, holding the metal match in one hand and a knife in the other. Scrape your knife against the metal match to produce sparks. The sparks will hit the tinder. When the tinder starts to smolder.",
                "5. Battery - Use a battery to generate a spark. Use of this method depends on the type of battery available. Attach a wire to each terminal. Touch the ends of the bare wires together next to the tinder so the sparks will ignite it.",
                "6. Gunpowder - Often, you will have ammunition with your equipment. If so, carefully extract the bullet from the shell casing, and use the gunpowder as tinder. A spark will ignite the powder. Be extremely careful when extracting the bullet from the case.",
                "7. Flint and Steel - The direct spark method is the easiest of the primitive methods to use. The flint and steel method is the most reliable of the direct spark methods. Strike a flint or other hard, sharp-edged rock edge with a piece of carbon steel (stainless steel will not produce a good spark). This method requires a loose-jointed wrist and practice. When a spark has caught in the tinder, blow on it. The spark will spread and burst into flames.",
                "8. Fire Plow - The fire-plow is a friction method of ignition. You rub a hardwood shaft against a softer wood base. To use this method, cut a straight groove in the base and plow the blunt tip of the shaft up and down the groove. The plowing action of the shaft pushes out small particles of wood fibers. Then, as you apply more pressure on each stroke, the friction ignites the wood particles.");

        SurvivalObject obj6 = new SurvivalObject("Flotation Devices",
                "1. If the water is warm enough for swimming and you do not have the time or materials to construct one of the poncho-type rafts, you can use various flotation devices to negotiate the water obstacle. Some items you can use for flotation devices are -",
                "2. Trousers. Knot each trouser leg at the bottom and close the fly. With both hands, grasp the waistband at the sides and swing the trousers in the air to trap air in each leg. Quickly press the sides of the waistband together and hold it underwater so that the air will not escape. You now have water wings to keep you afloat as you cross the body of water.",
                "3. Empty containers. Lash together her empty gas cans, water jugs, ammo cans, boxes, or other items that will trap or hold air. Use them as water wings. Use this type of flotation device only in a slow-moving river or stream.",
                "4. Plastic bags and ponchos. Fill two or more plastic bags with air and secure them together at the opening. Use your poncho and roll green vegetation tightly inside it so that you have a roll at least 20 centimeters in diameter. Tie the ends of the roll securely. You can wear it around your waist or across one shoulder and under the opposite arm.",
                "5. Logs. Use a stranded drift log if one is available, or find a log near the water to use as a float. Be sure to test the log before starting to cross. Some tree logs, palm for example, will sink even when the wood is dead. Another method is to tie two logs about 60 centimeters apart. Sit between the logs with your back against one and your legs over the other.",
                "6. Cattails. Gather stalks of cattails and tie them in a bundle 25 centimeters or more in diameter. The many air cells in each stalk cause a stalk to float until it rots. Test the cattail bundle to be sure it will support your weight before trying to cross a body of water.",
                "7. There are many other flotation devices that you can devise by using some imagination. Just make sure to test the device before trying to use it.",
                "");

        SurvivalObject obj7 = new SurvivalObject("Navigation - Moon Method",
                "1. Because the moon has no light of its own, we can only see it when it reflects the sun's light. As it orbits the earth on its 28-day circuit, the shape of the reflected light varies according to its position. We say there is a new moon or no moon when it is on the opposite side of the earth from the sun. Then, as it moves away from the earth's shadow, it begins to reflect light from its right side and waxes to become a full moon before waning, or losing shape, to appear as a sliver on the left side. You can use this information to identify direction.",
                "2. If the moon rises before the sun has set, the illuminated side will be the west. If the moon rises after midnight, the illuminated side will be the east. This obvious discovery provides us with a rough east-west reference during the night.",
                "",
                "",
                "",
                "",
                "",
                "");

        SurvivalObject obj8 = new SurvivalObject("Navigation - Shadow Method",
                "1. The earth's relationship to the sun can help you to determine direction on earth. The sun always rises in the east and sets in the west, but not exactly due east or due west. There is also some seasonal variation. In the northern hemisphere, the sun will be due south when at its highest point in the sky, or when an object casts no appreciable shadow. In the southern hemisphere, this same noonday sun will mark due north. In the northern hemisphere, shadows will move clockwise. Shadows will move counterclockwise in the southern hemisphere. With practice, you can use shadows to determine both direction and time of day. The shadow methods used for direction finding are the shadow-tip and watch methods.",
                "2. In the first shadow-tip method, find a straight stick 1 meter long, and a level spot free of brush on which the stick will cast a definite shadow. This method is simple and accurate and consists of four steps:",
                "3. Place the stick or branch into the ground at a level spot where it will cast a distinctive shadow. Mark the shadow's tip with a stone, twig, or other means. This first shadow mark is always west--everywhere on earth.",
                "4. Wait 10 to 15 minutes until the shadow tip moves a few centimeters. Mark the shadow tip's new position in the same way as the first.",
                "5. Draw a straight line through the two marks to obtain an approximate east-west line.",
                "6. Stand with the first mark (west) to your left and the second mark to your right--you are now facing north. This fact is true everywhere on earth.",
                "7. An alternate method is more accurate but requires more time. Set up your shadow stick and mark the first shadow in the morning. Use a piece of string to draw a clean arc through this mark and around the stick. At midday, the shadow will shrink and disappear. In the afternoon, it will lengthen again and at the point where it touches the arc, make a second mark. Draw a line through the two marks to get an accurate east-west line.",
                "");

        SurvivalObject obj9 = new SurvivalObject("Navigation - Watch Method",
                "1. You can also determine direction using a common or analog watch--one that has hands. The direction will be accurate if you are using true local time, without any changes for daylight savings time. Remember, the further you are from the equator, the more accurate this method will be. If you only have a digital watch, you can overcome this obstacle. Quickly draw a watch on a circle of paper with the correct time on it and use it to determine your direction at that time.",
                "2. In the northern hemisphere, hold the watch horizontal and point the hour hand at the sun. Bisect the angle between the hour hand and the 12 o'clock mark to get the north-south line. If there is any doubt as to which end of the line is north, remember that the sun rises in the east, sets in the west, and is due south at noon. The sun is in the east before noon and in the west after noon.",
                "3. If your watch is set on daylight savings time, use the midway point between the hour hand and 1 o'clock to determine the north-south line.",
                "4. In the southern hemisphere, point the watch's 12 o'clock mark toward the sun and a midpoint halfway between 12 and the hour hand will give you the north-south line.",
                "",
                "",
                "",
                "");

        SurvivalObject obj10 = new SurvivalObject("Shelter - Debris Hut",
                "1. Build it by making a tripod with two short stakes and a long ridgepole or by placing one end of a long ridgepole on top of a sturdy base.",
                "2. Secure the ridgepole (pole running the length of the shelter) using the tripod method or by anchoring it to a tree at about waist height.",
                "3. Prop large sticks along both sides of the ridgepole to create a wedge-shaped ribbing effect. Ensure the ribbing is wide enough to accommodate your body and steep enough to shed moisture.",
                "4. Place finer sticks and brush crosswise on the ribbing. These form a latticework that will keep the insulating material (grass, pine needles, leaves) from falling through the ribbing into the sleeping area.",
                "5. Add light, dry, if possible, soft debris over the ribbing until the insulating material is at least 1 meter thick--the thicker the better.",
                "6. Place a 30-centimeter layer of insulating material inside the shelter.",
                "7. At the entrance, pile insulating material that you can drag to you once inside the shelter to close the entrance or build a door.",
                "8. As a final step in constructing this shelter, add shingling material or branches on top of the debris layer to prevent the insulating material from blowing away in a storm.");

        SurvivalObject obj11 = new SurvivalObject("Signaling - Fire Method",
                "1. Night time - fire is the most effective visual means for signaling. Build three fires in a triangle (the international distress signal) or in a straight line with about 25 meters between the fires. Build them as soon as time and the situation permit and protect them until you need them. If you are alone, maintaining three fires may be difficult. If so, maintain one signal fire.",
                "2. When constructing signal fires, consider your geographic location. If in a jungle, find a natural clearing or the edge of a stream where you can build fires that the jungle foliage will not hide. You may even have to clear an area. If in a snow-covered area, you may have to clear the ground of snow or make a platform on which to build the fire so that melting snow will not extinguish it.",
                "3. A burning tree (tree torch) is another way to attract attention (Figure 19-1). You can set pitch-bearing trees afire, even when green. You can get other types of trees to burn by placing dry wood in the lower branches and igniting it so that the flames flare up and ignite the foliage. Before the primary tree is consumed, cut and add more small green trees to the fire to produce more smoke. Always select an isolated tree so that you do not start a forest fire and endanger yourself.",
                "4. Day time - build a smoke generator and use smoke to gain attention. The international distress signal is three columns of smoke. Try to create a color of smoke that contrasts with the background; dark smoke against a light background and vice versa. If you practically smother a large fire with green leaves, moss, or a little water, the fire will produce white smoke. If you add rubber or oil-soaked rags to a fire, you will get black smoke.",
                "",
                "",
                "",
                "");

        SurvivalObject obj12 = new SurvivalObject("Signaling - Mirror",
                "1. On a sunny day, a mirror is your best signaling device. If you don't have a mirror, polish your canteen cup, your belt buckle, or a similar object that will reflect the sun's rays. Direct the flashes in one area so that they are secure from enemy observation. Practice using a mirror or shiny object for signaling now; do not wait until you need it. If you have an MK-3 signal mirror, follow the instructions on its back.",
                "2. Reflect sunlight from mirror onto a nearby surface.",
                "3. Slowly bring up to eye level and look through sighting hole. You will see a bright spot or light. This is the aim indicatior.",
                "4. Hold mirror near the eye and slowly turn and manipulate it so that the bright spot of light is on the target.",
                "5. Even though no aircraft or ships may be in sight, continue to sweep the horizon. Mirror flashes may be seen for many miles.",
                "6. Wear the signal mirror on a cord or chain around your neck so that it is ready for immediate use.",
                "7. Do not direct the beam in the aircraft's cockpit for more than a few seconds as it may blind the pilot.",
                "8. Haze, ground fog, and mirages may make it hard for a pilot to spot signals from a flashing object. So, if possible, get to the highest point in your area when signaling. If you can't determine the aircraft's location, flash your signal in the direction of the aircraft noise.");

        SurvivalObject obj13 = new SurvivalObject("Water Purification",
                "1. Using water purification tablets. (Follow the directions provided.)",
                "2. Placing 5 drops of 2 percent tincture of iodine in a canteen full of clear water. If the canteen is full of cloudy or cold water, use 10 drops. (Let the canteen of water stand for 30 minutes before drinking.)",
                "3. Boiling water for 1 minute at sea level, adding 1 minute for each additional 300 meters above sea level, or boil for 10 minutes no matter where you are.",
                "",
                "",
                "",
                "",
                "");

        SurvivalObject obj14 = new SurvivalObject("Weapon - Club",
                "1. Simple Club - A simple club is a staff or branch. It must be short enough for you to swing easily, but long enough and strong enough for you to damage whatever you hit. Its diameter should fit comfortably in your palm, but it should not be so thin as to allow the club to break easily upon impact. A straight-grained hardwood is best if you can find it.",
                "2. Knife - A knife has three basic functions. It can puncture, slash or chop, and cut. A knife is also an invaluable tool used to construct other survival items. You may find yourself without a knife or you may need another type knife or a spear. To improvise you can use stone, bone, wood, or metal to make a knife or spear blade.",
                "3. Spear - Select a shaft (a straight sapling) 1.2 to 1.5 meters long. The length should allow you to handle the spear easily and effectively. Attach the spear blade to the shaft using lashing. The preferred method is to split the handle, insert the blade, then wrap or lash it tightly. You can use other materials without adding a blade. Select a 1.2-to 1.5-meter long straight hardwood shaft and shave one end to a point. If possible, fire harden the point. Bamboo also makes an excellent spear. Select a piece 1.2 to 1.5 meters long. Starting 8 to 10 centimeters back from the end used as the point, shave down the end at a 45-degree angle. Remember, to sharpen the edges, shave only the inner portion.",
                "4. Throwing Stick - The throwing stick, commonly known as the rabbit stick, is very effective against small game (squirrels, chipmunks, and rabbits). The rabbit stick itself is a blunt stick, naturally curved at about a 45-degree angle. Select a stick with the desired angle from heavy hardwood such as oak. Shave off two opposite sides so that the stick is flat like a boomerang. You must practice the throwing technique for accuracy and speed. First, align the target by extending the nonthrowing arm in line with the mid to lower section of the target. Slowly and repeatedly raise the throwing arm up and back until the throwing stick crosses the back at about a 45-degree angle or is in line with the nonthrowing hip. Bring the throwing arm forward until it is just slightly above and parallel to the nonthrowing arm. This will be the throwing stick's release point. Practice slowly and repeatedly to attain accuracy.",
                "",
                "",
                "",
                "");

        SurvivalObject obj15 = new SurvivalObject("",
                "1. ",
                "2. ",
                "3. ",
                "4. ",
                "5. ",
                "6. ",
                "",
                "");

        survivalArray.add(obj1);
        survivalArray.add(obj2);
        survivalArray.add(obj3);
        survivalArray.add(obj4);
        survivalArray.add(obj5);
        survivalArray.add(obj6);
        survivalArray.add(obj7);
        survivalArray.add(obj8);
        survivalArray.add(obj9);
        survivalArray.add(obj10);
        survivalArray.add(obj11);
        survivalArray.add(obj12);
        survivalArray.add(obj13);
        survivalArray.add(obj14);
        survivalArray.add(obj15);
    }


    @Override
    public void onListItemClick(ListView listView, View view, int pos, long id) {
        super.onListItemClick(listView, view, pos, id);

        SurvivalObject customObject = (SurvivalObject) listView.getAdapter().getItem(pos);

        Intent intent = new Intent(getActivity(), SurvivalActivityDetails.class);

        intent.putExtra("Name", customObject.getName());
        intent.putExtra("Step1", customObject.getSteps1());
        intent.putExtra("Step2", customObject.getSteps2());
        intent.putExtra("Step3", customObject.getSteps3());
        intent.putExtra("Step4", customObject.getSteps4());
        intent.putExtra("Step5", customObject.getSteps5());
        intent.putExtra("Step6", customObject.getSteps6());
        intent.putExtra("Step7", customObject.getSteps7());
        intent.putExtra("Step8", customObject.getSteps8());

        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();

        if (survivalArray != null){
            ArrayAdapter<SurvivalObject> listAdapter = new ArrayAdapter<SurvivalObject>(getActivity(), android.R.layout.simple_list_item_1, survivalArray);
            setListAdapter(listAdapter);
        }
    }
}
