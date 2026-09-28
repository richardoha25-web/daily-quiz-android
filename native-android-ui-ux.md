# RichInsights — Native Android V2 UI/UX Blueprint

## 1. Purpose

This document defines the V2 product experience for **RichInsights**, the native Android educational platform.

V2 is a new native experience. V1 is reference material only and must not constrain the new design.

## 2. Product experience

**Product:** RichInsights  
**Tagline:** **Grow. Excel.**

Core feeling: **Clean Competitive**

Target qualities:
- modern;
- polished;
- energetic;
- professional;
- accessible;
- easy to understand;
- educational without feeling childish.

Avoid:
- excessive gradients;
- visual clutter;
- generic unmodified Material styling;
- overly corporate or childish game styling;
- unnecessary decoration;
- inconsistent screen-by-screen visual languages.

## 3. Native design foundation

Use Kotlin + Jetpack Compose with a reusable RichInsights design system.

Define:
- typography;
- color roles;
- spacing;
- shapes;
- elevation;
- buttons;
- cards;
- inputs;
- dialogs;
- feedback;
- loading/error/empty states;
- navigation;
- ad containers;
- accessibility behavior.

Material 3 may provide primitives, but RichInsights needs its own visual identity.

## 4. Primary navigation

### Bottom navigation on compact phones

**Home | Learn | Quiz | Bible | News**

### Profile & Settings

Profile/settings is a secondary/global destination accessed from the top app bar/profile action.

### Larger screens

Use adaptive navigation, such as a navigation rail/navigation suite, rather than stretching a phone bottom bar across a large window. Android's current guidance explicitly recommends adapting navigation for larger window sizes. citeturn0search1turn0search9

Each primary destination should preserve its useful navigation state where appropriate.

## 5. Home

Home is the platform entry point.

Possible hierarchy:
1. greeting/personal context;
2. daily challenge;
3. progress/streak;
4. continue learning/playing;
5. categories or featured content;
6. relevant recommendations.

The exact content should be established through wireframes and testing rather than locked here.

## 6. Learn

Learn is the broader educational area.

It may contain:
- structured learning content;
- lessons;
- topics;
- explanations;
- future Study experiences;
- learning progress.

Do not force the entire future learning system into the first release. The navigation destination exists so the platform can grow beyond quizzes cleanly.

## 7. Quiz

Quiz is a major platform experience, not the entire app.

Initial areas:
- General Knowledge
- Science
- Africa & Nigeria
- Current Affairs
- Bible quizzes

The UI consumes validated question objects from the V2 content architecture. It must not know which provider generated them.

### Quiz screen

Target structure:
- navigation/back control;
- question number/progress;
- timer;
- question;
- answer options;
- relevant streak/progress;
- clear feedback.

The earlier V1 15-second timer is a reference requirement only. V2 should validate the final timing before locking it.

Answer states:
- default;
- pressed;
- selected;
- correct;
- incorrect;
- disabled/locked.

Feedback must be immediate, clear, and accessible.

## 8. Results and progress

Results should communicate:
- completion;
- score;
- accuracy;
- correct/wrong count;
- points;
- streak;
- progress;
- next action.

Future enhancements may include:
- explanations;
- topic performance;
- personalized recommendations;
- achievements;
- learning feedback.

## 9. Bible

Bible is a dedicated product area.

Conceptual structure:

```
Bible
├── Read Bible
│   ├── Book
│   ├── Chapter
│   └── Reader
├── Bible Quiz
└── Future Study
```

Reader requirements:
- offline reading when licensed content is available;
- book/chapter navigation;
- search;
- silent reading by default;
- user-triggered read-aloud;
- play/pause/resume/stop;
- future speed/voice controls.

Read-aloud must never start automatically.

## 10. News

News is a dedicated top-level experience.

It should be architecturally separate from the Current Affairs quiz category. A future news provider must not dictate the quiz UI or vice versa.

News features will be designed after product requirements and content/provider decisions are established.

## 11. Typography and interaction

Typography should prioritize:
- readable questions;
- strong headings;
- clear scores;
- comfortable body text;
- consistent hierarchy.

Ordinary learner-facing quiz/interface text should not be casually selectable/copyable. Use normal native Compose rendering rather than unnecessary text-selection containers.

This is not an absolute copy-prevention mechanism. Accessibility must not be damaged in pursuit of copy resistance.

Touch targets must be comfortable, and important meaning must never rely on color alone.

## 12. Visual direction

Initial direction:
- near-white foundation;
- strong blue primary identity;
- deep blue/navy hierarchy;
- dark readable text;
- muted secondary text;
- white surfaces/cards;
- green success;
- red incorrect/error;
- restrained amber/gold accent for points/streaks/rewards.

Final tokens must be validated for contrast and tested across screens.

## 13. Responsive/adaptive design

Design for:
- phones;
- larger phones;
- landscape;
- tablets;
- foldables;
- split-screen/changing window sizes.

Do not build a phone-only layout and retrofit larger screens later.

Where useful, larger windows may show multiple related panes instead of simply enlarging a single-column screen.

## 14. Connectivity states

Design explicit UI for:
- loading;
- connecting;
- offline;
- connection lost;
- empty;
- temporary failure;
- retry;
- quiz unavailable;
- ad unavailable;
- unexpected error.

Messages should be short, human-readable, and actionable. Never expose raw provider/API errors.

Example:

> **Internet connection required**  
> Connect to the internet to start a quiz.

Offline Bible reading must not be blocked merely because online quiz features require internet.

## 15. Advertising UX

V2 AdMob is a fresh implementation.

Rules:
- ads never cover quiz content or controls;
- the quiz remains usable if an ad fails;
- interstitials belong at appropriate transitions;
- rewarded ads are explicitly optional;
- development uses test ads;
- production identifiers/configuration remain separate;
- ad loading/failure states are handled gracefully.

Exact placements are implementation decisions and must be tested rather than copied blindly from V1.

## 16. Premium/billing UX

Future commercial surfaces may include:
- Premium landing/store;
- monthly/yearly subscriptions;
- Remove Ads;
- premium content;
- product benefits;
- purchase/restore states;
- active entitlement state.

Requirements:
- show value clearly;
- show price and billing period clearly;
- distinguish subscriptions from one-time products;
- explain entitlements;
- avoid deceptive urgency/aggressive paywalls;
- preserve user context through purchase flows.

Billing is planned, not an initial UI implementation requirement.

## 17. Accessibility

Requirements:
- sufficient contrast;
- do not rely on color alone;
- meaningful content descriptions where needed;
- comfortable touch targets;
- scalable text/layout;
- logical focus/navigation semantics;
- accessibility testing across major screens.

Copy-resistance must never become an excuse for inaccessible UI.

## 18. Motion

Motion should:
- confirm interactions;
- clarify transitions;
- communicate progress;
- reinforce meaningful feedback.

Avoid excessive motion during timed quizzes. Animations must remain performant on lower-end devices.

## 19. Reusable component foundation

Initial shared components:
- primary/secondary buttons;
- cards;
- category/content cards;
- answer options;
- progress indicators;
- timer;
- score display;
- streak indicator;
- dialogs;
- feedback;
- loading/error/empty states;
- navigation components;
- ad containers;
- premium/entitlement indicators.

Components should be designed as reusable system components, not one-off screen decorations.

## 20. Design process

**RESEARCH → WIREFRAME → DESIGN SYSTEM → HIGH-FIDELITY SCREENS → IMPLEMENT → BUILD → INSTALL → TEST → FIX → CHECKPOINT**

Do not design every future screen before its requirements are known.

## 21. Current V2 status

- RichInsights identity is the V2 direction.
- Native Android is the target implementation.
- Primary navigation is **Home / Learn / Quiz / Bible / News**.
- Profile & Settings is secondary/global.
- Adaptive navigation is required.
- Bible is a major product section.
- News is separate from Current Affairs.
- Quiz UI is provider-independent.
- AdMob and billing are fresh V2 work, not copied V1 implementations.
- High-fidelity implementation follows the native foundation and domain/content contracts.
